package com.example.dio.service.impl;


import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;
import com.example.dio.enums.UserRole;
import com.example.dio.exception.UserNotFoundByIdException;
import com.example.dio.mapper.UserMapper;
import com.example.dio.model.Admin;
import com.example.dio.model.Staff;
import com.example.dio.model.User;
import com.example.dio.repository.UserRepository;
import com.example.dio.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private static User createUserByRole(UserRole role) {
        User user;

        switch (role) {
            case ADMIN -> user = new Admin();
            case STAFF -> user = new Staff();
            default -> throw new RuntimeException("Failed to register user ,invalid user");
        }
        return user;
    }

    /**
     * Registers a new user based on the provided role.
     *
     * @param registrationRequest The request containing user registration details.
     * @return The response containing registered user details.
     */

    @Override
    public UserResponse registerUser(RegistrationRequest registrationRequest) {

        User user = this.createUserByRole(registrationRequest.getRole());

        userMapper.mapToUserEntity(registrationRequest, user);
        userRepository.save(user);
        return userMapper.mapToUserResponse(user);

    }
    /**
     * Retrieves a user by their unique ID.
     *
     * @param userId The unique identifier of the user.
     * @return The response containing user details if found.
     * @throws UserNotFoundByIdException If the user is not found by the given ID.
     */
    @Override
    public UserResponse findUserById(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException("Failed to find user,user not found by id"));
        return userMapper.mapToUserResponse(user);
    }
    /**
     * Updates an existing user's details.
     *
     * @param userId     The unique identifier of the user to be updated.
     * @param userRequest The request containing updated user information.
     * @return The response containing updated user details.
     * @throws UserNotFoundByIdException If the user is not found by the given ID.
     */
    @Override
    public UserResponse updateUserById(long userId, UserRequest userRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException("Failed to find user ,user not found by id"));

        this.userMapper.mapToUserEntity(userRequest, user);
        return userMapper.mapToUserResponse(user);


    }








}
