package org.finclutech.dashboard.service.impl;

import org.finclutech.dashboard.model.dto.ApplicationDTO;
import org.finclutech.dashboard.model.entity.Application;
import org.finclutech.dashboard.repository.ApplicationRepository;
import org.finclutech.dashboard.service.ApplicationService;
import org.finclutech.dashboard.service.mapper.ApplicationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public List<ApplicationDTO> findAll() {
        return applicationRepository.findAll().stream()
                .map(ApplicationMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationDTO findById(Long id) {
        Application application = applicationRepository.findById(id).orElse(null);
        return application != null ? ApplicationMapper.INSTANCE.toDto(application) : null;
    }

    @Override
    public ApplicationDTO save(ApplicationDTO applicationDTO) {
        Application application = ApplicationMapper.INSTANCE.toEntity(applicationDTO);
        application = applicationRepository.save(application);
        return ApplicationMapper.INSTANCE.toDto(application);
    }

    @Override
    public void deleteById(Long id) {
        applicationRepository.deleteById(id);
    }

}
