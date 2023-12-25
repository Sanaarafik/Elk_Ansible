package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entityDTO.RoleDTO;
import com.example.demo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        logger.info("In Controller : getAllUsers");
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable long id){
        logger.info("In Controller : getUserById");
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<Object> createNewUser(@RequestBody User user){
        logger.info("in userController : createNewUser ");
        if (userService.getUserByLogin(user.getLogin()).isEmpty()){
            userService.createNewUser(user);
            return new ResponseEntity<>("new user Created",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Please chose another login",HttpStatus.NOT_ACCEPTABLE);
        }

    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        logger.info("in userController : deleteUser");
        userService.deleteUser(id);
        return new ResponseEntity<>(String.format("User %d removed",id),HttpStatus.OK);
    }

    @PostMapping("user/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody RoleDTO roleDTO){
        logger.info("in userController : updateUser");
        return new ResponseEntity<>(userService.updateUser(id,roleDTO),HttpStatus.OK);
    }


}
