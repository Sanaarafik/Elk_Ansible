package com.UserService.UserService.Services;

import com.UserService.UserService.Entity.User;
import com.UserService.UserService.EntityDTO.RoleDTO;
import com.UserService.UserService.EntityDTO.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserService {

    public abstract Stream<UserDTO> getAllUsers();

    public abstract void putUser(User user);

    public abstract Optional<User> getUserById(long id);

    public abstract void createNewUser(User user);

    public abstract Optional<User> getUserByLogin(String Login);

    public abstract ResponseEntity<Object> deleteUser(Long id);

    public Optional<User> updateUser(Long id, RoleDTO roleDTO);

    public abstract Stream<UserDTO> getAllDemandeur();

    public abstract Stream<UserDTO> getAllBenevole();
    public abstract Stream<UserDTO> getAllValidator();

    public ResponseEntity<Object> linkValidatorToDemandeur(Long validatorId, Long demandeurId);
    public Boolean getLink(Long validatorId, Long demandeurId);

    public Boolean isUserAValidator(Long userId);

    public Boolean isUserADemandeur(Long userId);

    public Boolean isUserABenevole(Long userId);
}
