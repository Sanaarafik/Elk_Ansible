package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "validator")
@Data
public class Validator {

    @Id
    @Column(name = "user_id")
    private Long id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
