package com.springhealth.msahin.service;

import com.springhealth.msahin.model.Healthrecords;
import com.springhealth.msahin.repository.HealthRecordsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthRecordsService {
    private final HealthRecordsRepository healthRecordsRepository;

    public HealthRecordsService(HealthRecordsRepository healthRecordsRepository) {
        this.healthRecordsRepository = healthRecordsRepository;
    }

    public List<Healthrecords> getRecordsByUser(Integer userId) {
        return healthRecordsRepository.findByUserId(userId);
    }

    public Healthrecords createHealthRecord(Healthrecords healthrecords) {
        return healthRecordsRepository.save(healthrecords);
    }
}
