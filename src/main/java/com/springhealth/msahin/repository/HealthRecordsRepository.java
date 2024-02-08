package com.springhealth.msahin.repository;

import com.springhealth.msahin.model.Healthrecords;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthRecordsRepository extends JpaRepository<Healthrecords, Integer> {
    List<Healthrecords> findByUserId(Integer userId);
}
