package com.wipro.doc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doc.entity.QuestionBank;
import com.wipro.doc.exception.ResourceNotFoundException;
import com.wipro.doc.repository.QuestionBankRepository;

@Service
public class QuestionBankServiceImpl implements QuestionBankService {
    @Autowired
    private QuestionBankRepository questionRepository;

    @Override
    public List<QuestionBank> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public QuestionBank addQuestion(QuestionBank question) {
        return questionRepository.save(question);
    }

    @Override
    public QuestionBank updateQuestion(Long id, QuestionBank question) {
        QuestionBank existingQuestion = questionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + id));

        existingQuestion.setUser(question.getUser());
        existingQuestion.setQuestionText(question.getQuestionText());
        existingQuestion.setApproved(question.isApproved());
        existingQuestion.setStatus(question.getStatus());
        existingQuestion.setAnswers(question.getAnswers());
        existingQuestion.setTopic(question.getTopic());
        return questionRepository.save(existingQuestion);
    }

    @Override
    public void deleteQuestion(Long id) {
        if (!questionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Question not found with id: " + id);
        }
        questionRepository.deleteById(id);
    }

    @Override
    public QuestionBank getQuestionById(Long id) {
        return questionRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + id));
    }
}