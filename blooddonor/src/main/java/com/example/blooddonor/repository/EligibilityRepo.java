package com.example.blooddonor.repository;

import com.example.blooddonor.model.Eligible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EligibilityRepo extends JpaRepository<Eligible, Integer> {
    Eligible findByUserId(Integer id);
}
