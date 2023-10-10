package com.vibhusha.service;

import com.vibhusha.dto.UserDTO;
import com.vibhusha.model.User;
import com.vibhusha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO registerUser(UserDTO userDTO) {
        // Check if the user already exists




            User user = new User();

            user.setUserName(userDTO.getUserName());
            user.setPassword(userDTO.getPassword());
            user.setRole(userDTO.getRole());
            user.setAvatar(userDTO.getAvatar());
            user.setCreatedAt(userDTO.getCreatedAt());
            user.setToken(userDTO.getToken());


            User savedUser = userRepository.save(user);

            // Convert the saved User back to UserDTO
            UserDTO savedUserDTO = new UserDTO();

            savedUserDTO.setUserName(savedUser.getUserName());
            savedUserDTO.setPassword(savedUser.getPassword());
            savedUserDTO.setRole(savedUser.getRole());
            savedUserDTO.setAvatar(savedUser.getAvatar());
            savedUserDTO.setCreatedAt(savedUser.getCreatedAt());
            savedUserDTO.setToken(savedUser.getToken());

            return savedUserDTO;
        }
    }



