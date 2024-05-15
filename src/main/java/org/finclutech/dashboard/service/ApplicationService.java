package org.finclutech.dashboard.service;

import org.finclutech.dashboard.model.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {
    List<ApplicationDTO> findAll();
    ApplicationDTO findById(Long id);
    ApplicationDTO save(ApplicationDTO applicationDTO);
    void deleteById(Long id);

    List<ApplicationDTO> findByCategory(String category);

    List<ApplicationDTO> findByStatus(String status);

    void storeApplications(List<ApplicationDTO> fetchedApplications);
}