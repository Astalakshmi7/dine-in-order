package com.example.dio.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    @NotEmpty(message = "User name cannot be null or blank")
    @NotBlank(message = "User cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contains Alphabets, Number and Underscore")

    private String userName;

    @NotEmpty(message = "User name cannot be null or blank")
    @NotBlank(message = "User cannot be blank")
    @Email(regexp = "^[a-zA-Z0-9]+(?:[.+][a-zA-Z0-9]+)*@gmail\\.com$", message = "Email must be a valid Gmail address")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Phone number must contain only digits and be exactly 10 digits long")
    private String phoneNo;
}
