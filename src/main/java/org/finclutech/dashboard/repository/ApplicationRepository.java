package org.finclutech.dashboard.repository;

import org.finclutech.dashboard.model.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long>, JpaSpecificationExecutor<Application> {
    List<Application> findByBusinessCategory(String category);

    List<Application> findByApplicationStatus(String status);
}
