package com.springhealth.msahin.service;

import com.springhealth.msahin.model.Nutritiondiary;
import com.springhealth.msahin.repository.NutritionDiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutritionDiaryService {

    private final NutritionDiaryRepository nutritionDiaryRepository;

    public NutritionDiaryService(NutritionDiaryRepository nutritionDiaryRepository) {
        this.nutritionDiaryRepository = nutritionDiaryRepository;
    }

    public List<Nutritiondiary> getNutritionDiary(Integer userId){
        return nutritionDiaryRepository.findByUserId(userId);
    }

    public Nutritiondiary createNutrition(Nutritiondiary nutritiondiary){
        return nutritionDiaryRepository.save(nutritiondiary);
    }
}
