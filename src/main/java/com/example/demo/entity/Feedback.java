package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "feedback")
public class Feedback {


    @Id
    @Column(name = "feedback_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @MapsId
    @JoinColumn(name = "request_id")
    private Request request;

}
