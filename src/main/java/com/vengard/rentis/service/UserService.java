package com.vengard.rentis.service;

import com.vengard.rentis.model.User;
import com.vengard.rentis.repository.UserRepository;
import com.vengard.rentis.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    //ToDo deal with occupied email or username
    public User registerUser(User user) {
        if(!isEmailAvailable(user.getEmail()) || !isUsernameAvailable(user.getUsername()))
            return null;
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        UserRole userRole = userRoleRepository.findByRole("USER");
//        user.getRoles().add(userRole);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    private boolean isEmailAvailable(String email) {
        User user = userRepository.findByEmail(email);
        return user == null;
    }

    private boolean isUsernameAvailable(String username) {
        User user = userRepository.findByUsername(username);
        return user == null;
    }

    //ToDo change after introduce Spring Security
    public User getLoggedUser() {
        return userRepository.findById(1L).orElse(new User());
    }
}