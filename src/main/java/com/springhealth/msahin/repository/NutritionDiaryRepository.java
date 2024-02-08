package com.springhealth.msahin.repository;

import com.springhealth.msahin.model.Nutritiondiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutritionDiaryRepository extends JpaRepository<Nutritiondiary, Integer> {

    List<Nutritiondiary> findByUserId(Integer UserId);
}
