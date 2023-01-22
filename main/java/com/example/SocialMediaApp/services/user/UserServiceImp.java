package com.example.SocialMediaApp.services.user;

import com.example.SocialMediaApp.entities.User;
import com.example.SocialMediaApp.repos.UserRepository;
import com.example.SocialMediaApp.services.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User getAUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateUser(Long userId, User newUser) {
        Optional<User> availableUser = userRepository.findById(userId);
        if(availableUser.isPresent()){
            User user=availableUser.get();
            user.setUserName(newUser.getUserName());
            user.setPassword(newUser.getPassword());
            userRepository.save(user);
            return user;
        }
        else return null;
        }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
