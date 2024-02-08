package com.springhealth.msahin.controller;

import com.springhealth.msahin.model.Nutritiondiary;
import com.springhealth.msahin.service.NutritionDiaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nutrition")
public class NutritionDiaryController {

    private final NutritionDiaryService nutritionDiaryService;

    public NutritionDiaryController(NutritionDiaryService nutritionDiaryService) {
        this.nutritionDiaryService = nutritionDiaryService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Nutritiondiary>> getNutritionDiary(@PathVariable Integer userId) {
        return ResponseEntity.ok(nutritionDiaryService.getNutritionDiary(userId));
    }

    @PostMapping
    public ResponseEntity<Nutritiondiary> createNutritionRecord(@RequestBody Nutritiondiary nutritiondiary){
        Nutritiondiary createdNutritiondiary = nutritionDiaryService.createNutrition(nutritiondiary);
        return ResponseEntity.ok(createdNutritiondiary);
    }
}
