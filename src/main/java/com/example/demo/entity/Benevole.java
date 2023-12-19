package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "benevole")
public class Benevole {

    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
