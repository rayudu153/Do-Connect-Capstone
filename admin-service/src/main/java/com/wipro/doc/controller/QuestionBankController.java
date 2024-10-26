package com.wipro.doc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.doc.entity.QuestionBank;
import com.wipro.doc.service.QuestionBankService;
@RestController
@RequestMapping("/api/questions")

@CrossOrigin(origins = "*")
public class QuestionBankController {

    @Autowired
    private QuestionBankService questionService;

    @GetMapping
    public List<QuestionBank> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{id}")
    public QuestionBank getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }
    
    @PostMapping(
    	    consumes = MediaType.APPLICATION_JSON_VALUE,
    	    produces = MediaType.APPLICATION_JSON_VALUE
    	)
    	public ResponseEntity<QuestionBank> addQuestion(@RequestBody QuestionBank question) {
    	    try {
    	        QuestionBank savedQuestion = questionService.addQuestion(question);
    	        return ResponseEntity.ok(savedQuestion);
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	        return ResponseEntity.badRequest().build();
    	    }
    	}

    @PutMapping("/{id}")
    public QuestionBank updateQuestion(@PathVariable Long id, @RequestBody QuestionBank question) {
        return questionService.updateQuestion(id, question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }
}

