package com.example.blooddonor.dto;


import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StateDTO {

    private Integer id;
    private String name;

    @ManyToOne
    private CountryDTO county;

    public StateDTO(Integer id, String name) {

        this.setId(id);
        this.setName(name);
    }
}
