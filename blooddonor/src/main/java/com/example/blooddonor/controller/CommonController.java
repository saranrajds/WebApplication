package com.example.blooddonor.controller;

import com.example.blooddonor.dto.*;
import com.example.blooddonor.model.BloodGroup;
import com.example.blooddonor.model.Country;
import com.example.blooddonor.service.ICityService;
import com.example.blooddonor.service.IDistrictService;
import com.example.blooddonor.service.IStateService;
import com.example.blooddonor.service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommonController {

    @Autowired
    private IUserService userBusinessService;
    @Autowired
    private IStateService stateService;
    @Autowired
    private IDistrictService districtService;
    @Autowired
    private ICityService cityService;

    @GetMapping("/onGetStateByCountryId")
    public ResponseEntity<List<StateDTO>> onGetStateByCountryId(@RequestParam("countryId") Long countryId) {
        List<StateDTO> states = stateService.onGetStateByCountryId(countryId);
        if (states != null || !states.isEmpty())
            return ResponseEntity.ok(states);
        else
            return ResponseEntity.status(200).body(null);
    }

    @GetMapping("/onGetDistrictByStateId")
    public ResponseEntity<List<DistrictDTO>> onGetDistrictByStateId(@RequestParam("stateId") Long stateId) {
        List<DistrictDTO> districts = districtService.onGetStateById(stateId);
        if (districts != null || !districts.isEmpty())
            return ResponseEntity.ok(districts);
        else
            return ResponseEntity.status(200).body(null);
    }

    @GetMapping("/onGetCityByDistrictId")
    public ResponseEntity<List<CityDTO>> onGetCityByDistrictId(@RequestParam("districtId") Long districtId) {
        List<CityDTO> cities = cityService.onGetCityByDistrictId(districtId);
        if (cities != null || !cities.isEmpty())
            return ResponseEntity.ok(cities);
        else
            return ResponseEntity.status(200).body(null);
    }

    @PostMapping("/onFindDonors")
    public ResponseEntity<List<UserDTO>> onFindDonors(@RequestBody BloodDonorSearchDTO bloodDonorSearchDTO) {

        System.out.println("bloodDonorSearchDTO "+bloodDonorSearchDTO);
        List<UserDTO> users = userBusinessService.findUsersByCriteria(bloodDonorSearchDTO);

        if (users != null || !users.isEmpty())
            return ResponseEntity.ok(users);
        else
            return ResponseEntity.status(200).body(users);
    }

}
