package com.example.blooddonor.repository;

import com.example.blooddonor.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepo extends JpaRepository<Credential, Integer> {
    Credential findByEmail(String email);
    Credential findByPassword(String password);
}
