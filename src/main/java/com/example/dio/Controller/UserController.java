package com.example.dio.Controller;

import com.example.dio.model.User;
import com.example.dio.service.UserService;
import com.example.dio.until.ResponseBuilder;
import com.example.dio.until.ResponseStruture;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<ResponseStruture<String>>registerUser(@RequestBody User user){
        user=userService.registerUser(user);





         return ResponseBuilder.success(HttpStatus.CREATED,"User Created","user");

    }


}