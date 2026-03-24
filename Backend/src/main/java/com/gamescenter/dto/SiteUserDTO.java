package com.gamescenter.dto;

import java.time.LocalDate;

import com.gamescenter.model.Role;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiteUserDTO {
    Long id;

    String firstName;
    String surname;
    LocalDate dob;

    @Email
    @NotBlank
    String email;
    String username;
    String password;

    @Enumerated(EnumType.STRING)
    Role role;
}
