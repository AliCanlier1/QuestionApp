package com.springbootproject.QuestionApp.controllers;

import com.springbootproject.QuestionApp.entities.User;
import com.springbootproject.QuestionApp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userID}")
    public User getUserById(@PathVariable("userID") int id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{userID}")
    public Optional<User> updateUserById(@PathVariable("userID") int id, @RequestBody User newUser) {
        return userService.updateUserById(id, newUser);
    }

    @DeleteMapping("/{userID}")
    public String deleteUser(@PathVariable("userID") int id) {
        return userService.deleteUser(id);
    }


}
