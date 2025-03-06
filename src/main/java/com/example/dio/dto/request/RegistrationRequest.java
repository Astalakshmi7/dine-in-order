package com.example.dio.dto.request;

import com.example.dio.enums.UserRole;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationRequest {

    @NotEmpty(message = "UserName cannot be null or blank")
    @NotBlank(message = "UserName cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contains Alphabets, Number and Underscore")
    private String userName;

    @NotEmpty(message = "Email cannot be null or blank")
    @NotBlank(message = "Email cannot be blank")
    @Email(regexp = "^[a-zA-Z0-9]+(?:[.+][a-zA-Z0-9]+)*@gmail\\.com$", message = "Email must be a valid Gmail address")
    private String email;


    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$", message = "Minimum 8 charachter ,Upper case,lower case, special character,numbers")
    private String password;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number must contain only digits and be exactly 10 digits long")
    private String phoneNo;
    private UserRole role;

}
