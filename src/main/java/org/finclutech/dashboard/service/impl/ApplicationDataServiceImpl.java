package org.finclutech.dashboard.service.impl;

import org.finclutech.dashboard.model.dto.ApplicationDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
public class ApplicationDataServiceImpl {
    private final RestTemplate restTemplate;

    @Value("${external.api.url}")
    private String apiUrl;

    public ApplicationDataServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ApplicationDTO> fetchApplications() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<List<ApplicationDTO>> response = restTemplate.exchange(
                    apiUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<List<ApplicationDTO>>() {
                    });
            return response.getBody();
        } catch (RestClientException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to fetch data from external API", e);
        }
    }
}