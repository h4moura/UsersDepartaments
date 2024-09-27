package com.devhalyson.userdept.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.devhalyson.userdept.entities.User;
import com.devhalyson.userdept.repositories.UserRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> findAll() {
       List<User> result = repository.findAll();
       return result;
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable Long id) {
       User result = repository.findById(id).get();
       return result;
    }

    @PostMapping
    public User insert(@RequestBody User user) {
       User result = repository.save(user);
       return result;
    }

    @PutMapping(value = "/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
       
        User existingUser = repository.findById(id).orElse(null);
        
        if (existingUser != null) {
            
            existingUser.setName(user.getName());  
            existingUser.setEmail(user.getEmail());  
            User updatedUser = repository.save(existingUser);
            return updatedUser;
        } 
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
