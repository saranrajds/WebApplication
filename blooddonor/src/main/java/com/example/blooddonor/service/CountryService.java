package com.example.blooddonor.service;

import com.example.blooddonor.model.Country;
import com.example.blooddonor.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService{

    @Autowired
    private CountyRepository countyRepository;

    @Override
    public List<Country> getAllCountry() {
        List<Country> countries = countyRepository.findAll();
        return countries;
    }
}
