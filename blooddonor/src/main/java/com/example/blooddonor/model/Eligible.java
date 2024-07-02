package com.example.blooddonor.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "eligibility")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Eligible {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String isWeight;

    @Column(nullable = false)
    private String isTransmittableDisease;

    @Column(nullable = false)
    private String disease;

    @Column(nullable = false)
    private String isAsthama;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
