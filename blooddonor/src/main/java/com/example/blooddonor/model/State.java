package com.example.blooddonor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}
