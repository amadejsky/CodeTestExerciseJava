package com.amadejsky.rest_manager_task02.controller;

import com.amadejsky.rest_manager_task02.model.User;
import com.amadejsky.rest_manager_task02.service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody User user){
        User createdUser = userService.addUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getUsers();
    }
    @DeleteMapping()
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
    }

}
