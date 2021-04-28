package com.microservices.simplestore.services;

import java.util.List;

import com.microservices.simplestore.dms.DataManager;
import com.microservices.simplestore.entities.User;
import com.microservices.simplestore.models.CreateUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private DataManager dataManager;

    public User saveUser(CreateUser user) {
        return dataManager.saveUser(user);
    }

    public List<User> getAllUsers() {
        return dataManager.getAllUsers();
    }

    public User getUserById(int id) {
        return dataManager.getUserById(id);

    }

    public User getUserByName(String name) {
        return dataManager.getUserByName(name);
    }

    public void deleteUserById(int id) {
        dataManager.deleteUserById(id);
    }
}
