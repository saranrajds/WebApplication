package com.example.blooddonor.service;

import com.example.blooddonor.dto.CityDTO;
import com.example.blooddonor.model.City;
import com.example.blooddonor.repository.CityRepository;

import java.util.List;

public interface ICityService {

    public List<City> getAllCities();

    List<CityDTO> onGetCityByDistrictId(Long districtId);
}
