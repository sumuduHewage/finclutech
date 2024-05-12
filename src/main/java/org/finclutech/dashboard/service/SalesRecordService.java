package org.finclutech.dashboard.service;



import org.finclutech.dashboard.model.dto.SalesRecordDTO;

import java.util.List;
import java.util.Optional;

public interface SalesRecordService{
    List<SalesRecordDTO> findAll();
    Optional<SalesRecordDTO> findById(Long id);
    SalesRecordDTO save(SalesRecordDTO salesRecordDTO);
    void deleteById(Long id);
}
