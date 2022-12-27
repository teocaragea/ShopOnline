package com.example.shoponline.service;

import com.example.shoponline.model.User;
import com.example.shoponline.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("Running test for saveNewUser method")
    void saveNewUserTest(){
        User user = new User("teocaragea", "pass1234");
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.saveNewUser(user);

        assertEquals(user.getUserName(), result.getUserName());
        assertEquals(user.getPassword(), result.getPassword());

    }

    @Test
    void retrieveUsersTest(){

        User user = new User("teocaragea", "pass1234");
        List<User> users = new ArrayList<>();
        users.add(user);
        when(userRepository.findAll()).thenReturn(users);

        List<User> results = userService.retrieveUsers();

        assertEquals(results.size(),users.size());

    }


}
