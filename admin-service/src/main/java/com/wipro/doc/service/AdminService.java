package com.wipro.doc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doc.entity.DoConnectUser;
import com.wipro.doc.entity.QuestionBank;

@Service
public class AdminService {
    @Autowired
    private DoConnectUserServiceImpl userService;

    @Autowired
    private QuestionBankServiceImpl questionService;

    // User Management through AdminService
    public List<DoConnectUser> getAllUsers() {
        return userService.getAllUsers();
    }

    public DoConnectUser updateUser(Long id, DoConnectUser user) { // Changed int to Long
        return userService.updateUser(id, user);
    }

    public void deleteUser(Long id) { // Changed int to Long
        userService.deleteUser(id);
    }
    
    public DoConnectUser getUserById(Long id) { // Changed int to Long
        return userService.getUserById(id);
    }

    // Question Management through AdminService
    public List<QuestionBank> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    public QuestionBank addQuestion(QuestionBank question) {
        return questionService.addQuestion(question);
    }

    public QuestionBank updateQuestion(Long id, QuestionBank question) {
        return questionService.updateQuestion(id, question);
    }

    public void deleteQuestion(Long id) {
        questionService.deleteQuestion(id);
    }
}
