package com.skvm.user_service.controller;

import com.skvm.user_service.dto.UpdateUserRequest;
import com.skvm.user_service.entity.User;
import com.skvm.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest dto) {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> patchUser(@PathVariable Long id, @Valid @RequestBody UpdateUserRequest dto){
        return ResponseEntity.ok(userService.patchUser(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        Map<String,String> response = new HashMap<>();
        response.put("message","User with ID-"+id+" was successfully deleted.");
        return ResponseEntity.ok(response);
    }
}