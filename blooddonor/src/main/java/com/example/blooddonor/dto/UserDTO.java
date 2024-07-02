package com.example.blooddonor.dto;

import com.example.blooddonor.model.Credential;
import com.example.blooddonor.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private String username;
    private String password;
    private String role;
    private String email;
    private String mobileNo;
    private Integer bloodGroup_Id;
    private Integer country_Id;
    private Integer stated_Id;
    private Integer district_Id;
    private Integer city_Id;
    private User user;

    public static UserDTO fromEntity(User user) {
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
}
