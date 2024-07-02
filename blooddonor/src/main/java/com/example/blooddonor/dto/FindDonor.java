package com.example.blooddonor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindDonor {

    private String bloodGroup;
    private String coutry;
    private String stated;
    private String district;
    private String city;

}
