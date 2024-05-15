package org.finclutech.dashboard.repository;

import org.finclutech.dashboard.model.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByBusinessCategory(String category);

    List<Application> findByApplicationStatus(String status);
}
