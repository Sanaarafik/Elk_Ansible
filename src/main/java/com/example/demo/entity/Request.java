package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "request")
public class Request {

    @Id
    @Column(name = "request_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_status")
    private RefStatus refStatus;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;




}
