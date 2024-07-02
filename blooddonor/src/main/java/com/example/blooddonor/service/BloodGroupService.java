package com.example.blooddonor.service;

import com.example.blooddonor.model.BloodGroup;
import com.example.blooddonor.repository.BloodGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodGroupService implements IBloodGroupService{

    @Autowired
    private BloodGroupRepository bloodGroupRepository;

    @Override
    public List<BloodGroup> getAllBloodGroups() {

        return bloodGroupRepository.findAll();
    }
}
