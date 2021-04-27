package com.microservices.simplestore.repositories;

import java.util.Optional;

import com.microservices.simplestore.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    public Optional<User> findByName(String name);
}
