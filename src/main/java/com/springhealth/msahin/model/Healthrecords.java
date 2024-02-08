package com.springhealth.msahin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "healthrecords")
public class Healthrecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RecordID")
    private Integer recordId;

    @ManyToOne
    @JoinColumn(name="UserId", nullable=false) // updatable=false, insertable=false
    private Users user;

    @Column(name = "BloodPressure")
    private String bloodPressure;

    @Column(name = "BloodSugar")
    private String bloodSugar;

    @Column(name = "HeartRate")
    private String heartRate;

    @Column(name = "RecordDate")
    @Temporal(TemporalType.DATE)
    private Date recordDate;



}
