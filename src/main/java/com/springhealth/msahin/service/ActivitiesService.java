package com.springhealth.msahin.service;

import com.springhealth.msahin.model.Activities;
import com.springhealth.msahin.repository.ActivitiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivitiesService {

    private final ActivitiesRepository activitiesRepository;

    public ActivitiesService(ActivitiesRepository activitiesRepository) {
        this.activitiesRepository = activitiesRepository;
    }

    public List<Activities> getActivitiesByUser(Integer userId) {
        return activitiesRepository.findByUserId(userId);
    }

    public Activities createActivity(Activities activities) {
        return activitiesRepository.save(activities);
    }

}
