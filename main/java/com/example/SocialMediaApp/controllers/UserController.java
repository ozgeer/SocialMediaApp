package com.example.SocialMediaApp.controllers;

import com.example.SocialMediaApp.entities.User;
import com.example.SocialMediaApp.services.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
    return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getOneUser(@PathVariable Long userId){
        //custom exception
       return userService.getOneUser(userId);
    }

    @PutMapping("{userId}")
    public User updateUser(@PathVariable Long userId,@RequestBody User newUser){
       return userService.updateUser(userId,newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Long userId){
        userService.deleteById(userId);
    }
}

