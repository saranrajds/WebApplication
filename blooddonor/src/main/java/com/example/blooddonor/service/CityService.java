package com.example.blooddonor.service;

import com.example.blooddonor.dto.CityDTO;
import com.example.blooddonor.dto.StateDTO;
import com.example.blooddonor.model.City;
import com.example.blooddonor.model.State;
import com.example.blooddonor.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService implements ICityService{

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public List<CityDTO> onGetCityByDistrictId(Long districtId) {

        List<City> cities = cityRepository.findByDistrictId(districtId);
        return cities.stream()
                .map(citie -> new CityDTO(citie.getId(), citie.getName()))
                .collect(Collectors.toList());

    }

}
