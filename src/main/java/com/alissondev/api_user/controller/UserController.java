package com.alissondev.api_user.controller;

import com.alissondev.api_user.business.UserService;
import com.alissondev.api_user.infrastructure.entitys.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestBody String email) {
        userService.deleteUserByEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUser(@RequestBody Long id, User user) {
        userService.updateUserById(id, user);
        return ResponseEntity.ok().build();
    }
}
