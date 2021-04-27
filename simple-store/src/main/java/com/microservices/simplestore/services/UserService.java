package com.microservices.simplestore.services;

import java.util.List;
import java.util.Optional;

import com.microservices.simplestore.entities.User;
import com.microservices.simplestore.exceptions.UserNotFoundException;
import com.microservices.simplestore.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    // private DataManager dataManager;

    @Autowired
    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        Optional<User> optUser = userRepository.findById(id);
        if (!optUser.isPresent())
            throw new UserNotFoundException("User does not exist");
        return optUser.get();

    }

    public User getUserByName(String name) {
        Optional<User> optUser = userRepository.findByName(name);
        if (!optUser.isPresent())
            throw new UserNotFoundException("User does not exist"); // this is repeated across a few methods. Consider for dataManager?
        return optUser.get();
    }

    public void deleteUserById(int id) {
        Optional<User> optUser = userRepository.findById(id);
        if (!optUser.isPresent())
            throw new UserNotFoundException("User does not exist");
        userRepository.delete(optUser.get());
    }
}
