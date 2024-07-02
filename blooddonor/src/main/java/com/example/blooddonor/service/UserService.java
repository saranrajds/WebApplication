package com.example.blooddonor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.blooddonor.dto.EligibleDTO;
import com.example.blooddonor.dto.BloodDonorSearchDTO;
import com.example.blooddonor.model.Credential;
import com.example.blooddonor.model.Eligible;
import com.example.blooddonor.repository.CredentialRepo;
import com.example.blooddonor.repository.EligibilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.blooddonor.dto.UserDTO;
import com.example.blooddonor.mapper.UserMapper;
import com.example.blooddonor.model.User;
import com.example.blooddonor.repository.UserRepo;

@Service
public class UserService implements IUserService{
	
	    @Autowired
	    private UserRepo userRepository;
		@Autowired
		private CredentialRepo credentialRepo;

		private User currentUser;

		@Autowired
		private EligibilityRepo eligibilityRepo;

	    @Override
		public String addUser(UserDTO userDTO) {

			System.out.println(userDTO.getBloodGroup_Id() +" "+ userDTO.getCountry_Id() +" "+ userDTO.getStated_Id()
					+" "+ userDTO.getDistrict_Id() +" "+ userDTO.getCity_Id());

			if (userDTO.getBloodGroup_Id() == null || userDTO.getCountry_Id() == null || userDTO.getStated_Id() == null
					|| userDTO.getDistrict_Id() == null || userDTO.getCity_Id() == null) {
				throw new IllegalArgumentException("All IDs must be provided");
			}

			User user = UserMapper.toEntity(userDTO);
			Credential credential = UserMapper.toCred(userDTO,user);
			currentUser=user;
            userRepository.save(user);
			credential.setUser(user);
			credentialRepo.save(credential);
			return user.getUsername();
		}

	    @Override
	    public List<UserDTO> getUser() {

	        List<User> users = userRepository.findAll();
	        List<UserDTO> userDTOS = new ArrayList<>();
	        for(User user: users) {
	            userDTOS.add(UserMapper.toDto(user));
	        }

	        return userDTOS;
	    }

	@Override
	public Credential authenticate(String email, String password) {
		Credential credential = credentialRepo.findByEmail(email);
		if(credential !=null && credentialRepo.findByPassword(password)!=null) {
			Optional<User> user = userRepository.findById(credential.getUser().getId());
			if (user.isPresent()) {
				currentUser = user.get();
			}
			return credential;
		}
		return null;
	}

	@Override
	public Eligible healthDetails(EligibleDTO eligibleDTO) {
		Eligible eligible = UserMapper.toEligible(eligibleDTO,currentUser);
		if(eligibilityRepo.findByUserId(eligible.getUser().getId()) == null) {
			eligibilityRepo.save(eligible);
			return eligible;
		}
		else{
			Eligible eligible1=eligibilityRepo.findByUserId(eligible.getUser().getId());

			eligible1.setIsWeight(eligibleDTO.getIsWeight());
			eligible1.setIsTransmittableDisease(eligibleDTO.getIsTransmittableDisease());
			eligible1.setIsAsthama(eligibleDTO.getIsAsthama());
			eligible1.setDisease(eligibleDTO.getDisease());
			eligibilityRepo.save(eligible1);
			return eligible;
		}

	}

	@Override
	public Eligible getUserEligible() {

		return eligibilityRepo.findByUserId(currentUser.getId());
    }

	@Override
	public List<UserDTO> findUsersByCriteria(BloodDonorSearchDTO searchDTO) {
		List<User> users = userRepository.findUsersByCriteria(
				searchDTO.getBloodGroupId(),
				searchDTO.getCountryId(),
				searchDTO.getStateId(),
				searchDTO.getDistrictId(),
				searchDTO.getCityId());

		System.out.println("findUsersByCriteria "+users);

		return users.stream().map(UserDTO::fromEntity).collect(Collectors.toList());
	}

}
