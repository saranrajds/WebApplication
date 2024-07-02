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
public class CredentialDTO {

    private String email;
    private String password;
    private String role;
}