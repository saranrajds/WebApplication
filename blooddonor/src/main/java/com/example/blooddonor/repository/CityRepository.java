package com.example.blooddonor.repository;

import com.example.blooddonor.dto.CityDTO;
import com.example.blooddonor.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByDistrictId (Long districtId);
}
