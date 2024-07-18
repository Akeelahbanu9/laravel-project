package com.example.gamescore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.gamescore.entity.User;
import com.example.gamescore.repository.UserRepository;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

	
	  @Autowired
	    private UserRepository userRepository;

	    @PostMapping
	    public ResponseEntity<User> createUser(@RequestBody User user) {
	        try {
	            User newUser = userRepository.save(user);
	            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("/{userId}")
	    public ResponseEntity<User> getUserById(@PathVariable int userId) {
	        Optional<User> userOptional = userRepository.findById(userId);
	        if (userOptional.isPresent()) {
	            return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<User>> getAllUsers() {
	        List<User> users = userRepository.findAll();
	        if (!users.isEmpty()) {
	            return new ResponseEntity<>(users, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
	    }

}