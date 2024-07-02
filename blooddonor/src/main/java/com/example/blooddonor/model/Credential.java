package com.example.blooddonor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "credential", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credential {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Password is required")
    @Column(nullable = false)
    private String password;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email is required")
    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
