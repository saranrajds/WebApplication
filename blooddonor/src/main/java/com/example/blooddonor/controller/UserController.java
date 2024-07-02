package com.example.blooddonor.controller;

import java.util.List;

import com.example.blooddonor.dto.*;
import com.example.blooddonor.model.BloodGroup;
import com.example.blooddonor.model.Country;
import com.example.blooddonor.model.Credential;
import com.example.blooddonor.model.Eligible;
import com.example.blooddonor.service.IBloodGroupService;
import com.example.blooddonor.service.ICountryService;
import com.example.blooddonor.service.IStateService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.blooddonor.service.IUserService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IBloodGroupService bloodGroupService;
    @Autowired
    private ICountryService countryService;
	@Autowired
    private IUserService userBusinessService;
    @Autowired
    private IStateService stateService;
	
	@PostMapping("/addUser")
    public String addUser(UserDTO userDTO)  {
        logger.info("Received addUser request: {}", userDTO);
        String newUser = userBusinessService.addUser(userDTO);
        return "redirect:/bdonor?fragmentToLoad=register";
    }

    @GetMapping("/getUser")
    public List<UserDTO> getUser() {
        List<UserDTO> newUser = userBusinessService.getUser();
        return newUser;
    }

    @PostMapping("/login")
    public String login(CredentialDTO credential,HttpSession session)  {
        String email = credential.getEmail();
        String password = credential.getPassword();
        Credential credential1=userBusinessService.authenticate(email,password);
        if(credential1 != null){
            session.setAttribute("username",credential1.getUser().getUsername());
            return "redirect:/home?fragmentToLoad=dashboard";
        }else
         return "redirect:/login";
    }

    @PostMapping("/eligibleDonor")
    public String eligibleForm(EligibleDTO eligibleDTO, RedirectAttributes redirectAttributes) {
        Eligible addEligible=userBusinessService.healthDetails(eligibleDTO);
        if (addEligible!=null) {
                redirectAttributes.addFlashAttribute("userEligible", addEligible);
                return "redirect:/home?fragmentToLoad=profile";
        }
        return "redirect:/home?fragmentToLoad=profile";
    }

    @GetMapping("/getValue")
    public String getValueInProfile(RedirectAttributes redirectAttributes){
        Eligible eligible=userBusinessService.getUserEligible();
        if(eligible!=null){
            redirectAttributes.addFlashAttribute("userEligible", eligible);
            return "redirect:/home?fragmentToLoad=profile";
        }
        return "redirect:/home?fragmentToLoad=profile";
    }

    @PostMapping("/onfindBloodDonor")
    public String  onfindBloodDonor(@ModelAttribute BloodDonorSearchDTO request, HttpSession session, Model model)  {

        List<UserDTO> users = userBusinessService.findUsersByCriteria(request);
        List<BloodGroup> bloodGroups = bloodGroupService.getAllBloodGroups();
        List<Country> countries = countryService.getAllCountry();
        List<StateDTO> states = stateService.onGetStateByCountryId(request.getCountryId());


        model.addAttribute("bloodGroups", bloodGroups);
        model.addAttribute("countries", countries);
        model.addAttribute("users", users);
        model.addAttribute("SearchCriteria", request);

        System.out.println("Search criteria: " + request);
        return "donordetail";
    }
}
