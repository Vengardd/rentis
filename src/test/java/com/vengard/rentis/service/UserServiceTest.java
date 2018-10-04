package com.vengard.rentis.service;

import com.vengard.rentis.model.User;
import com.vengard.rentis.model.UserRole;
import com.vengard.rentis.repository.UserRepository;
import com.vengard.rentis.repository.UserRoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserRoleRepository userRoleRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Before
    public void init() {
        when(userRoleRepository.findByRole("USER")).thenReturn(new UserRole("USER"));
    }

    @Test
    public void registerUser_withAvailableUsernameAndEmail() {
        User user = new User();
        user.setPassword("aa");

        when(userRepository.findByUsername(user.getUsername())).thenReturn(null);
        when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
        when(userRepository.save(user)).thenReturn(user);

        User newUser = userService.registerUser(user);

        assertNotNull(newUser);
        assertNotNull(newUser.getRoles());
    }

    @Test
    public void registerUser_withOccupiedEmail() {
        User user1 = new User();
        user1.setEmail("aa");
        user1.setPassword("aa");

        User user2 = new User();
        user2.setEmail("aa");
        user2.setPassword("bb");


        when(userRepository.findByUsername(user1.getUsername())).thenReturn(user1);
        when(userRepository.findByUsername(user2.getUsername())).thenReturn(user2);
        when(userRepository.save(user1)).thenReturn(user1);
        when(userRepository.save(user2)).thenReturn(user2);

        User newUser = userService.registerUser(user2);

        assertNull(newUser);
    }
}
