package com.example.blooddonor.service;

import java.util.List;

import com.example.blooddonor.dto.BloodDonorSearchDTO;
import com.example.blooddonor.dto.CredentialDTO;
import com.example.blooddonor.dto.EligibleDTO;
import com.example.blooddonor.dto.UserDTO;
import com.example.blooddonor.dto.BloodDonorSearchDTO;
import com.example.blooddonor.model.Credential;
import com.example.blooddonor.model.Eligible;

public interface IUserService {

    String addUser(UserDTO userDTO);

    List<UserDTO> getUser();

    Credential authenticate(String email, String password);

    Eligible healthDetails(EligibleDTO eligibleDTO);

    Eligible getUserEligible();

    List<UserDTO> findUsersByCriteria(BloodDonorSearchDTO request);
}
