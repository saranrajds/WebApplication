package com.example.blooddonor.mapper;

import com.example.blooddonor.dto.EligibleDTO;
import com.example.blooddonor.dto.UserDTO;
import com.example.blooddonor.model.*;

import java.util.Optional;

public class UserMapper {

	public static UserDTO toDto(User user) {
		return UserDTO.builder()
				.username(user.getUsername())
				.mobileNo(user.getMobileNo())
				.bloodGroup_Id(user.getBloodGroupId())
				.country_Id(user.getCountryId())
				.stated_Id(user.getStateId())
				.district_Id(user.getDistrictId())
				.city_Id(user.getCityId())
				.build();
	}

	public static User toEntity(UserDTO userDTO) {
		return User.builder()
				.username(userDTO.getUsername())
				.mobileNo(userDTO.getMobileNo())
				.bloodGroupId(userDTO.getBloodGroup_Id())
				.countryId(userDTO.getCountry_Id())
				.stateId(userDTO.getStated_Id())
				.districtId(userDTO.getDistrict_Id())
				.cityId(userDTO.getCity_Id())
				.build();
	}

	public static Credential toCred(UserDTO userDTO,User user) {
		return Credential.builder()
				.email(userDTO.getEmail())
				.password(userDTO.getPassword())
//				.role(userDTO.getRole())
				.user(user)
				.build();
	}

	public static Eligible toEligible(EligibleDTO eligibleDTO, User user) {
		 return Eligible.builder()
				 .isWeight(eligibleDTO.getIsWeight())
				 .isTransmittableDisease(eligibleDTO.getIsTransmittableDisease())
				 .disease(eligibleDTO.getDisease())
				 .isAsthama(eligibleDTO.getIsAsthama())
				 .user(user)
				 .build();
	}
}
