package com.example.blooddonor.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "district_Id", nullable = false)
    private District district;
}
