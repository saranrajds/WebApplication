package com.example.blooddonor.repository;

import com.example.blooddonor.dto.StateDTO;
import com.example.blooddonor.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {

//    List<StateDTO> findAllById(Long countryId);
        List<State> findByCountryId(Long countryId);
}
