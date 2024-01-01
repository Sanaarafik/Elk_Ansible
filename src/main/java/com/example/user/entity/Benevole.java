package com.example.user.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "benevole")
public class Benevole {

    @Id
    @Column(name = "user_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
