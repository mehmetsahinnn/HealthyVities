package com.springhealth.msahin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Integer id;

    @Column(name = "Username", nullable = false, unique = true)
    private String username;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "CreatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date creationdate;

    @Column(name = "isAdmin")
    private Integer isAdmin;

    @Column(name = "Height")
    private Integer height;

    @Column(name = "Weight")
    private Integer weight;

}
