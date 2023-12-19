package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "User")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name="login")
    private String login;


    @Column(name="password")
    private String password;

    @Transient
    private Boolean isDemandeur;

    @Transient
    private Boolean isValidator;

    @Transient
    private Boolean isBenevole;

}
