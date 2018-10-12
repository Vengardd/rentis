package com.vengard.rentis.controller;

import com.vengard.rentis.model.User;
import com.vengard.rentis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registerUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

}
