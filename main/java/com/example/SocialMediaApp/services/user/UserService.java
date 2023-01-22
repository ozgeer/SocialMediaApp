package com.example.SocialMediaApp.services.user;

import com.example.SocialMediaApp.entities.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User newUser);
    User getAUserById(Long userId);
    User updateUser(Long userId,User newUser);
    void deleteById(Long userId);
}
