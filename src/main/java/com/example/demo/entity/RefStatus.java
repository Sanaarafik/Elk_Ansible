package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "refStatus")
public class RefStatus {

    @Id
    @Column(name = "id_status")
    private Long id;

    @Column(name = "status_value")
    private String status;

}
