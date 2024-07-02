package com.example.blooddonor.service;

import com.example.blooddonor.dto.DistrictDTO;
import com.example.blooddonor.model.District;

import java.util.List;

public interface IDistrictService {

    List<DistrictDTO> onGetStateById(Long stateId);
}
