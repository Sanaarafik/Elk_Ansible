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

    @OneToOne(cascade = CascadeType.REMOVE)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
