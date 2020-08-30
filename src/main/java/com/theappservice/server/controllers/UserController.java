package com.theappservice.server.controllers;

import java.util.List;

import javax.validation.Valid;

import com.theappservice.server.repository.services.UserService;
import com.theappservice.server.repository.entities.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping
    @CrossOrigin(origins = {Environment.DEV_URL, Environment.PROD_URL})
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> list = service.getAllUsers();
        return new ResponseEntity<List<UserEntity>>(
            list,
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = {Environment.DEV_URL, Environment.PROD_URL})
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<UserEntity>(
            service.getUser(id),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @PostMapping
    @CrossOrigin(origins = {Environment.DEV_URL, Environment.PROD_URL})
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserEntity newUser) {
        return new ResponseEntity<UserEntity>(
            service.createUser(newUser),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @PutMapping
    @CrossOrigin(origins = {Environment.DEV_URL, Environment.PROD_URL})
    public ResponseEntity<UserEntity> updateUser(@Valid @RequestBody UserEntity user) {
        return new ResponseEntity<UserEntity>(
            service.updateUser(user),
            new HttpHeaders(),
            HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = {Environment.DEV_URL, Environment.PROD_URL})
    public HttpStatus deleteUserById(@PathVariable("id") Long userID) throws Exception {
        try {
            service.deleteUser(userID);
            return HttpStatus.OK;
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
