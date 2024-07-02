package com.example.blooddonor.service;

import com.example.blooddonor.dto.DistrictDTO;
import com.example.blooddonor.dto.StateDTO;
import com.example.blooddonor.model.District;
import com.example.blooddonor.model.State;
import com.example.blooddonor.repository.DistrictRepository;
import com.example.blooddonor.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DistrictService implements IDistrictService{

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public List<DistrictDTO> onGetStateById(Long stateId) {

        List<District> districts = districtRepository.findByStateId(stateId);
        return districts.stream()
                .map(district -> new DistrictDTO(district.getId(), district.getName()))
                .collect(Collectors.toList());
    }
}
