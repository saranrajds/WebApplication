package com.example.blooddonor.service;

import com.example.blooddonor.dto.StateDTO;
import com.example.blooddonor.model.State;
import com.example.blooddonor.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StateService implements IStateService{

    @Autowired
    private StateRepository stateRepository;

    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    @Override
    public List<StateDTO> onGetStateByCountryId(Long countryId) {
        List<State> states = stateRepository.findByCountryId(countryId);
        return states.stream()
                .map(state -> new StateDTO(state.getId(), state.getName()))
                .collect(Collectors.toList());
    }

}
