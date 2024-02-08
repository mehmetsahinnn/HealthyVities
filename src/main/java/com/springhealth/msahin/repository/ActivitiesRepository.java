package com.springhealth.msahin.repository;

import com.springhealth.msahin.model.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivitiesRepository extends JpaRepository<Activities, Integer> {
    List<Activities> findByUserId(Integer userId);

}
