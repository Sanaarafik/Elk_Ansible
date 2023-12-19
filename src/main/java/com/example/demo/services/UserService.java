package com.example.demo.services;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    public abstract List<User> getAllUsers();

    public abstract void putUser(User user);

    public abstract Optional<User> getUserById(long id);
}
