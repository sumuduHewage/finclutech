package org.finclutech.dashboard.repository;

import org.finclutech.dashboard.model.entity.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRecordRepository extends JpaRepository<SalesRecord, Long> {
}