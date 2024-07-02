package com.example.blooddonor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "mobileNo"),
        @UniqueConstraint(columnNames = "email"),
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Username is required")
    @Size(min = 4, max = 50, message = "Username must be between 4 and 50 characters")
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty(message = "Mobile number is required")
    @Column(nullable = false, unique = true)
    private String mobileNo;

    @Column(name = "blood_group_id", nullable = false)
    private Integer bloodGroupId;

    @Column(name = "country_id", nullable = false)
    private Integer countryId;

    @Column(name = "state_id", nullable = false)
    private Integer stateId;

    @Column(name = "district_id", nullable = false)
    private Integer districtId;

    @Column(name = "city_id", nullable = false)
    private Integer cityId;


    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean flag=false;

    @PrePersist
    protected void onCreate() {
        createdAt = updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Credential credential;

}
