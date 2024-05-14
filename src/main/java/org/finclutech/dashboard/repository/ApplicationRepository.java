package org.finclutech.dashboard.repository;

import org.finclutech.dashboard.model.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
