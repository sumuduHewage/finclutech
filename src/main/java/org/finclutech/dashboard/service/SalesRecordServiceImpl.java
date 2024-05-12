package org.finclutech.dashboard.service;


import org.finclutech.dashboard.model.dto.SalesRecordDTO;
import org.finclutech.dashboard.model.entity.SalesRecord;
import org.finclutech.dashboard.repository.SalesRecordRepository;
import org.finclutech.dashboard.service.mapper.SalesRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalesRecordServiceImpl implements SalesRecordService {

    private final SalesRecordRepository salesRecordRepository;
    private final SalesRecordMapper mapper = SalesRecordMapper.INSTANCE;

    @Autowired
    public SalesRecordServiceImpl(SalesRecordRepository salesRecordRepository) {
        this.salesRecordRepository = salesRecordRepository;
    }

    @Override
    public List<SalesRecordDTO> findAll() {
        return salesRecordRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public Optional<SalesRecordDTO> findById(Long id) {
        return salesRecordRepository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public SalesRecordDTO save(SalesRecordDTO salesRecordDTO) {
        SalesRecord salesRecord = mapper.toEntity(salesRecordDTO);
        salesRecord = salesRecordRepository.save(salesRecord);
        return mapper.toDto(salesRecord);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteById(Long id) {
        salesRecordRepository.deleteById(id);
    }
}
