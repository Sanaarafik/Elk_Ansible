package com.UserService.UserService.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "demandeur")
public class Demandeur {

    @Id
    @Column(name = "user_id")
    private Long id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User demandeur;

}
