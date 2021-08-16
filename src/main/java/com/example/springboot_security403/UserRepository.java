package com.example.springboot_security403;

import org.springframework.data.repository.CrudRepository;

//CRUD - create, read, update, delete
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
