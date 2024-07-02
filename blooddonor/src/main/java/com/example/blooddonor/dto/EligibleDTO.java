package com.example.blooddonor.dto;

import com.example.blooddonor.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EligibleDTO {

    private String isWeight;
    private String isTransmittableDisease;
    private String disease;
    private String isAsthama;
    private User user;
}
