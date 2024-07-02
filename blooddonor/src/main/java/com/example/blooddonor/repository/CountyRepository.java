package com.example.blooddonor.repository;

import com.example.blooddonor.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountyRepository extends JpaRepository<Country, Long> {
}
