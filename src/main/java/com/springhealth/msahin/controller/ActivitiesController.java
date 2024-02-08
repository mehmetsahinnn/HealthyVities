package com.springhealth.msahin.controller;

import com.springhealth.msahin.model.Activities;
import com.springhealth.msahin.service.ActivitiesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivitiesController {

    private final ActivitiesService activitiesService;

    public ActivitiesController(ActivitiesService activitiesService) {
        this.activitiesService = activitiesService;
    }

    @GetMapping("/user/{userID}")
    public ResponseEntity<List<Activities>> getActivitiesByUser(@PathVariable Integer userID) {
        return ResponseEntity.ok(activitiesService.getActivitiesByUser(userID));
    }

    @PostMapping
    public ResponseEntity<Activities> createActivity(@RequestBody Activities activities) {
        Activities createdActivity = activitiesService.createActivity(activities);
        return ResponseEntity.ok(createdActivity);
    }

}
