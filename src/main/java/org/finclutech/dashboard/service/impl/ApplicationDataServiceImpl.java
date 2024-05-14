package org.finclutech.dashboard.service.impl;

import org.finclutech.dashboard.model.dto.ApplicationDTO;
import org.finclutech.dashboard.repository.ApplicationRepository;
import org.finclutech.dashboard.service.mapper.ApplicationMapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ApplicationDataServiceImpl {
    private final ApplicationRepository applicationRepository;
    private final RestTemplate restTemplate;

    public ApplicationDataServiceImpl(ApplicationRepository applicationRepository, RestTemplate restTemplate) {
        this.applicationRepository = applicationRepository;
        this.restTemplate = restTemplate;
    }

    public void fetchAndStoreApplications() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "https://68.183.176.148:8901/v1/getNewApplications";
        ResponseEntity<List<ApplicationDTO>> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, new ParameterizedTypeReference<List<ApplicationDTO>>() {});
        List<ApplicationDTO> applicationDtos = response.getBody();
        if (applicationDtos != null) {
            applicationDtos.forEach(dto -> applicationRepository.save(ApplicationMapper.INSTANCE.toEntity(dto)));
        }
    }
}