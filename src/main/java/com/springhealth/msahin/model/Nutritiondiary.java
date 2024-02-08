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
@Table(name = "nutritiondiary")
public class Nutritiondiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EntryId")
    private Integer EntryId;

    @ManyToOne
    @JoinColumn(name="UserId", nullable=false) // updatable=false, insertable=false
    private Users user;

    @Column(name = "Meal")
    private String meal;

    @Column(name = "Calories")
    private Integer calories;

    @Column(name = "NutritionDetails")
    private String nutritionDetails;

    @Column(name = "EntryDate")
    private Date entryDate;

}
