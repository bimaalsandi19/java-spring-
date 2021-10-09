package com.example.test.api.crud.controllers;

import com.example.test.api.crud.entities.UserEntity;
import com.example.test.api.crud.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "checkAPI")
    public String checkAPI(){
        return "Hello World";
    }

//    create
    @PostMapping(value = "addUser")
    public UserEntity addUser(@RequestBody UserEntity param){
        userRepository.save(param);
        return param;
    }
//    Read
    @GetMapping(value = "findAllUser")
    public List<UserEntity> findAllUser(){
        return userRepository.findAll();
    }
//    Read By ID
    @GetMapping(value = "findById")
    public UserEntity findById(@RequestParam int id){
        return userRepository.findById(id).get();
    }

//    Update
    @PostMapping(value = "updateUser")
    public UserEntity updateUser(@RequestBody UserEntity param){
        return userRepository.save(param);
    }

//    delete
    @GetMapping(value = "deleteUser")
    public String deleteUser(@RequestParam int id){
        userRepository.deleteById(id);
        return "Success delete User id: "+id;
    }
}
