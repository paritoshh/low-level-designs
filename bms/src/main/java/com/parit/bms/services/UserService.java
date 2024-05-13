package com.parit.bms.services;

import com.parit.bms.models.User;
import com.parit.bms.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    public User createUser(String username, String password) {
        User newUser = User.builder().
                username(username)
                .password(password)
                .build();
        return userRepository.save(newUser);
    }
}
