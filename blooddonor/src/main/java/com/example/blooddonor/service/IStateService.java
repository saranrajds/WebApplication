package com.example.blooddonor.service;

import com.example.blooddonor.dto.StateDTO;
import com.example.blooddonor.model.State;

import java.util.List;

public interface IStateService {

    public List<State> getAllStates();

    List<StateDTO> onGetStateByCountryId(Long countryId);

}
