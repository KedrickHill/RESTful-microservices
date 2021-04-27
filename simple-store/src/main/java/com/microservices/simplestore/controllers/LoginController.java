package com.microservices.simplestore.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.microservices.simplestore.entities.User;
import com.microservices.simplestore.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class LoginController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showHomePage() {
        return "Welcome to Home Page";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "This is the Login Page";
    }

    @GetMapping("/login/{name}")
    public String loginSuccess(@PathVariable String name) {
        return String.format("Welcome to the Store, %s!", name);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.saveUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id]").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUserById(id);
    }
}
