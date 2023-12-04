package com.springbootproject.QuestionApp.services;

import com.springbootproject.QuestionApp.entities.User;
import com.springbootproject.QuestionApp.repos.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public Optional<User> updateUserById(int id, @RequestBody User newUser) {
        Optional<User> oldUser = userRepository.findById(id);
        if (oldUser.isPresent()) {
            User currentUser = oldUser.get();
            currentUser.setUserName(newUser.getUserName());
            currentUser.setId(newUser.getId());
            currentUser.setPassword(newUser.getPassword());
            userRepository.save(currentUser);
            return Optional.of(currentUser);
        } else {
            return Optional.empty();
        }

    }

    public String deleteUser(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User currentUser = user.get();
            userRepository.delete(currentUser);
            return "The user whose id is: " + currentUser.getId() + " have been deleted";
        } else {
            return "The user couldn't find";
        }
    }


}
