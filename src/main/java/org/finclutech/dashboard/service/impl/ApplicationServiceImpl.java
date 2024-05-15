package org.finclutech.dashboard.service.impl;

import org.finclutech.dashboard.model.dto.ApplicationDTO;
import org.finclutech.dashboard.model.entity.Application;
import org.finclutech.dashboard.repository.ApplicationRepository;
import org.finclutech.dashboard.service.ApplicationService;
import org.finclutech.dashboard.service.mapper.ApplicationMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    @Override
    public List<ApplicationDTO> findByCategory(String category) {
        return applicationRepository.findByBusinessCategory(category).stream()
                .map(ApplicationMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationDTO> findByStatus(String status) {
        return applicationRepository.findByApplicationStatus(status).stream()
                .map(ApplicationMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<Application> findApplications(String searchText, LocalDate createdDate, LocalDate updatedDate) {
        Specification<Application> spec = ApplicationSpecification.getApplicationsByFilter(searchText, createdDate, updatedDate);
        return applicationRepository.findAll(spec);
    }


    @Override
    @Transactional
    public void storeApplications(List<ApplicationDTO> applicationDtos) {
        try {
            if (applicationDtos != null) {
                applicationDtos.forEach(dto -> {
                    Application application = ApplicationMapper.INSTANCE.toEntity(dto);
                    if (dto.getId() != null) {
                        if (!applicationRepository.existsById(dto.getId())) {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application with ID " + dto.getId() + " not found");
                        }
                    }
                    applicationRepository.save(application);
                });
            }
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error accessing the database", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error processing request", e);
        }
    }

}
