package com.example.blooddonor.controller;

import com.example.blooddonor.model.BloodGroup;
import com.example.blooddonor.model.Country;
import com.example.blooddonor.model.Eligible;
import com.example.blooddonor.service.IBloodGroupService;
import com.example.blooddonor.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class RoutingController {

	@Autowired
	private IBloodGroupService bloodGroupService;
	@Autowired
	private ICountryService countryService;

	@RequestMapping("/index")
	public String index() {
		return "redirect:/bdonor?fragmentToLoad=main";
	}

	@RequestMapping("/register")
	public String register() {
		return "register";
	}

	@RequestMapping("/home")
	public String home(@RequestParam(name = "fragmentToLoad") String fragmentToLoad,Model model, HttpSession session) {
		Object getEligible=model.asMap().get("userEligible");
		if(getEligible!=null) {
			Eligible eligible=(Eligible)getEligible;
			model.addAttribute("eligibles", eligible);
		}
		session.setAttribute("role", "donor");
		model.addAttribute("fragmentToLoad", fragmentToLoad);
		return "home";
	}

	@RequestMapping("/bdonor")
	public String donorIndex(@RequestParam(name = "fragmentToLoad") String fragmentToLoad,Model model,HttpSession session, RedirectAttributes redirectAttributes) {
		model.addAttribute("fragmentToLoad", fragmentToLoad);

		List<BloodGroup> bloodGroups = bloodGroupService.getAllBloodGroups();
		List<Country> countries = countryService.getAllCountry();

		model.addAttribute("bloodGroups", bloodGroups);
		model.addAttribute("countries", countries);
		return "index";
	}

}
