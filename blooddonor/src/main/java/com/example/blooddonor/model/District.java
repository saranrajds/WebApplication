package com.example.blooddonor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id", nullable = false)
    private State state;
}
