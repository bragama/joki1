package com.project.projectakhir.controller;

import com.project.projectakhir.entity.User;
import com.project.projectakhir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    private ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity(userService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/login/{name}/{password}")
    private ResponseEntity<List<User>> getLoginUser(@PathVariable("name") String name, @PathVariable("password") String password){
        return new ResponseEntity(userService.loginUser(name, password), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    private ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        return new ResponseEntity(userService.findById(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    private ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity(userService.createUser(user), HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    private ResponseEntity<User> updateUserById(@PathVariable("id") Long id,
                                                @RequestBody User user){
        return new ResponseEntity(userService.updateUser(id, user), HttpStatus.OK);
    }
}
