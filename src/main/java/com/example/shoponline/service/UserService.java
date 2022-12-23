package com.example.shoponline.service;

import com.example.shoponline.model.NaturalStone;
import com.example.shoponline.model.User;
import com.example.shoponline.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveNewUser(User user) {
        return userRepository.save(user);
    }

    public List<User> retrieveUsers(){
        return userRepository.findAll();
    }
}
