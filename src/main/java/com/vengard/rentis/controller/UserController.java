package com.vengard.rentis.controller;

import com.vengard.rentis.model.RentHistory;
import com.vengard.rentis.model.User;
import com.vengard.rentis.service.RentHistoryService;
import com.vengard.rentis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RentHistoryService rentHistoryService;

    @PostMapping
    public User registerUser(@Valid @RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/user/history")
    public List<RentHistory> getRentHistory() {
        return rentHistoryService.findRentHistoryByUser(userService.getLoggedUser());
    }

    @RequestMapping("/user")
    public User getLoggedUser() {
        return userService.getLoggedUser();
    }
}
