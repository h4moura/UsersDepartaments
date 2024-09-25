package com.devhalyson.userdept.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devhalyson.userdept.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
