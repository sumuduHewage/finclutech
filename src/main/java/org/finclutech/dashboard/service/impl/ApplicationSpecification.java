package org.finclutech.dashboard.service.impl;

import org.finclutech.dashboard.model.entity.Application;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationSpecification {

    public static Specification<Application> getApplicationsByFilter(String searchText, LocalDate createdDate, LocalDate updatedDate) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // search in multiple fields
            if (searchText != null && !searchText.isEmpty()) {
                String pattern = "%" + searchText + "%";
                Predicate searchPredicate = cb.or(
                        cb.like(cb.lower(root.get("salesAgentFirstName")), pattern),
                        cb.like(cb.lower(root.get("salesAgentLastName")), pattern),
                        cb.like(cb.lower(root.get("salesAgentEmail")), pattern),
                        cb.like(cb.lower(root.get("applicationStatus")), pattern)
                );
                predicates.add(searchPredicate);
            }

            // filter by created date
            if (createdDate != null) {
                LocalDateTime startOfDay = createdDate.atStartOfDay(); // Start of the day
                predicates.add(cb.greaterThanOrEqualTo(root.get("createdAt"), startOfDay));
            }

            // filter by updated date
            if (updatedDate != null) {
                LocalDateTime endOfDay = LocalDateTime.of(updatedDate, LocalTime.MAX); // End of the day
                predicates.add(cb.lessThanOrEqualTo(root.get("updatedAt"), endOfDay));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
