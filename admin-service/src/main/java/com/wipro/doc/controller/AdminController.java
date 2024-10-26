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
import org.springframework.web.bind.annotation.RestController;

import com.wipro.doc.entity.DoConnectUser;
import com.wipro.doc.entity.QuestionBank;
import com.wipro.doc.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/users")
    public List<DoConnectUser> getAllUsers() {
        return adminService.getAllUsers();
    }

    @PutMapping("/users/{id}")
    public DoConnectUser updateUser(@PathVariable Long id, @RequestBody DoConnectUser user) {
        return adminService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        adminService.deleteUser(id);
    }

    @GetMapping("/questions")
    public List<QuestionBank> getAllQuestions() {
        return adminService.getAllQuestions();
    }

    @PostMapping("/questions")
    public QuestionBank addQuestion(@RequestBody QuestionBank question) {
        return adminService.addQuestion(question);
    }

    @PutMapping("/questions/{id}")
    public QuestionBank updateQuestion(@PathVariable Long id, @RequestBody QuestionBank question) {
        return adminService.updateQuestion(id, question);
    }

    @DeleteMapping("/questions/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        adminService.deleteQuestion(id);
    }
}

