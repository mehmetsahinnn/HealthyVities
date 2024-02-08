package com.springhealth.msahin.controller;

import com.springhealth.msahin.model.Activities;
import com.springhealth.msahin.model.Healthrecords;
import com.springhealth.msahin.model.Nutritiondiary;
import com.springhealth.msahin.repository.HealthRecordsRepository;
import com.springhealth.msahin.service.HealthRecordsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/healthrecords")
public class HealthRecordsController {

    private final HealthRecordsService healthRecordsService;

    public HealthRecordsController(HealthRecordsService healthRecordsService) {
        this.healthRecordsService = healthRecordsService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Healthrecords>> getAllRecords(@PathVariable Integer userId) {
        return ResponseEntity.ok(healthRecordsService.getRecordsByUser(userId));
    }

    @PostMapping
    public ResponseEntity<Healthrecords> createHealthRecord(@RequestBody Healthrecords healthrecords){
        Healthrecords createdHealthRecord = healthRecordsService.createHealthRecord(healthrecords);
        return ResponseEntity.ok(createdHealthRecord);
    }

}
