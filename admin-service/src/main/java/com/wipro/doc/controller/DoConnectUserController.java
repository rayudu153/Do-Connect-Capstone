package com.wipro.doc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.doc.entity.DoConnectUser;
import com.wipro.doc.service.DoConnectUserService;
@RestController
@RequestMapping("/api/users")
public class DoConnectUserController {

    @Autowired
    private DoConnectUserService userService;

    @PostMapping("/register")
    public DoConnectUser registerUser(@RequestBody DoConnectUser user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public DoConnectUser loginUser(@RequestParam String username, @RequestParam String password) {
        return userService.loginUser(username, password);
    }

    @GetMapping
    public List<DoConnectUser> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public DoConnectUser getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public DoConnectUser updateUser(@PathVariable Long id, @RequestBody DoConnectUser user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

