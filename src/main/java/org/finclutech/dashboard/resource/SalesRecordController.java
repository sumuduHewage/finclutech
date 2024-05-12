package org.finclutech.dashboard.resource;


import org.finclutech.dashboard.model.dto.SalesRecordDTO;
import org.finclutech.dashboard.service.SalesRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-records")
public class SalesRecordController {

    private final SalesRecordService salesRecordService;

    @Autowired
    public SalesRecordController(SalesRecordService salesRecordService) {
        this.salesRecordService = salesRecordService;
    }


    @GetMapping
    public ResponseEntity<List<SalesRecordDTO>> getAllSalesRecords() {
        List<SalesRecordDTO> records = salesRecordService.findAll();
        return ResponseEntity.ok(records);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesRecordDTO> getSalesRecordById(@PathVariable Long id) {
        return salesRecordService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<SalesRecordDTO> createSalesRecord(@RequestBody SalesRecordDTO salesRecordDTO) {
        SalesRecordDTO newRecord = salesRecordService.save(salesRecordDTO);
        return ResponseEntity.ok(newRecord);
    }


    @PutMapping("/{id}")
    public ResponseEntity<SalesRecordDTO> updateSalesRecord(@PathVariable Long id, @RequestBody SalesRecordDTO salesRecordDTO) {
        salesRecordDTO.setId(id);
        SalesRecordDTO updatedRecord = salesRecordService.save(salesRecordDTO);
        return ResponseEntity.ok(updatedRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesRecord(@PathVariable Long id) {
        salesRecordService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
