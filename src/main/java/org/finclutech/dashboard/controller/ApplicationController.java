package org.finclutech.dashboard.controller;

import org.finclutech.dashboard.model.dto.ApplicationDTO;
import org.finclutech.dashboard.service.ApplicationService;
import org.finclutech.dashboard.service.impl.ApplicationDataServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    private final ApplicationDataServiceImpl applicationDataService;

    public ApplicationController(ApplicationService applicationService,ApplicationDataServiceImpl applicationDataService) {
        this.applicationService = applicationService;
        this.applicationDataService = applicationDataService;
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDTO>> getAllApplications() {
        return ResponseEntity.ok(applicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDTO> getApplicationById(@PathVariable Long id) {
        ApplicationDTO dto = applicationService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
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

    @GetMapping("/fetch")
    public void fetchApplications() {
        applicationDataService.fetchAndStoreApplications();
    }
}
