package com.springhealth.msahin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "activities")
public class Activities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ActivityID")
    private Integer activityId;

    @ManyToOne
    @JoinColumn(name = "UserId", nullable = false)
    private Users user;

    @Column(name = "ActivityType")
    private String activityType;

    @Column(name = "Duration")
    private Double duration;

    @Column(name = "Distance")
    private Double distance;

    @Column(name = "ActivityDate")
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date activityDate;

}
