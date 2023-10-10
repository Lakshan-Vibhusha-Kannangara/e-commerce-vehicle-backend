package com.vibhusha.controller;

import com.vibhusha.dto.UserDTO;
import com.vibhusha.model.User;

import com.vibhusha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/login") // Set the base request mapping for the controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/register") // Relative path to register endpoint
    public UserDTO registerUser(@RequestBody UserDTO user) {

        return userService.registerUser(user);
    }
}
