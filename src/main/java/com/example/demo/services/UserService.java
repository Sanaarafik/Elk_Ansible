package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.entityDTO.RoleDTO;
import com.example.demo.entityDTO.UserDTO;

import java.util.Optional;
import java.util.stream.Stream;


public interface UserService {

    public abstract Stream<UserDTO> getAllUsers();

    public abstract void putUser(User user);

    public abstract Optional<User> getUserById(long id);

    public abstract void createNewUser(User user);

    public abstract Optional<User> getUserByLogin(String Login);

    public abstract void deleteUser(Long id);

    public Optional<User> updateUser(Long id, RoleDTO roleDTO);
}
