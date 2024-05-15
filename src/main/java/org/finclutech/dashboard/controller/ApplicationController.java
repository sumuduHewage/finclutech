package org.finclutech.dashboard.controller;

import org.finclutech.dashboard.model.dto.ApplicationDTO;
import org.finclutech.dashboard.service.ApplicationService;
import org.finclutech.dashboard.service.impl.ApplicationDataServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    private final ApplicationDataServiceImpl applicationDataService;

    public ApplicationController(ApplicationService applicationService, ApplicationDataServiceImpl applicationDataService) {
        this.applicationService = applicationService;
        this.applicationDataService = applicationDataService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDTO> getApplicationById(@PathVariable Long id) {
        ApplicationDTO dto = applicationService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDTO>> getAllApplications() {
        try {
            List<ApplicationDTO> applications = applicationService.findAll();
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<ApplicationDTO> createApplication(@RequestBody ApplicationDTO applicationDTO) {
        return ResponseEntity.ok(applicationService.save(applicationDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationDTO> updateApplication(@PathVariable Long id, @RequestBody ApplicationDTO applicationDTO) {
        return ResponseEntity.ok(applicationService.save(applicationDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<ApplicationDTO>> getApplicationsByCategory(@PathVariable String category) {
        try {
            List<ApplicationDTO> applications = applicationService.findByCategory(category);
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ApplicationDTO>> getApplicationsByStatus(@PathVariable String status) {
        try {
            List<ApplicationDTO> applications = applicationService.findByStatus(status);
            return ResponseEntity.ok(applications);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping("/fetch")
    public ResponseEntity<?> fetchAndStoreApplications() {
        try {
            List<ApplicationDTO> fetchedApplications = applicationDataService.fetchApplications();
            applicationService.storeApplications(fetchedApplications);
            return ResponseEntity.ok().body("Successfully fetched and stored applications.");
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getReason());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to fetch or store applications: " + e.getMessage());
        }
    }
}
