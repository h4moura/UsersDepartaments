package com.devhalyson.userdept.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devhalyson.userdept.entities.User;
import com.devhalyson.userdept.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll() {
        repository.findAll();
        {
            List<User> result = repository.findAll();
            return result;
        }
    }

    @GetMapping(value = "/{id}")
    public Optional<User> findById(@PathVariable Long id) {
        Optional<User> result = repository.findById(id);
        return result;
    }

    @PostMapping(value = "/{id}")
    public User insrt(@RequestBody User user) {
        User result = repository.save(user);
        return result;
    }

}
