package com.example.dio.Controller;

import com.example.dio.model.User;
import com.example.dio.service.UserService;
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
    public ResponseEntity<ResponseStruture<User>>registerUser(@RequestBody User user){
        user=userService.registerUser(user);


        ResponseStruture<User>struture =new ResponseStruture<>();
        struture.setData(user);
        struture.setStatus(HttpStatus.CREATED.value());
        struture.setMessage("User Created");

         return new ResponseEntity<ResponseStruture<User>>(struture,HttpStatus.CREATED);

    }


}