package com.wipro.doc.service;

import java.util.List;

import com.wipro.doc.entity.QuestionBank;

public interface QuestionBankService {
    List<QuestionBank> getAllQuestions();
    QuestionBank getQuestionById(Long id);
    QuestionBank addQuestion(QuestionBank question);
    QuestionBank updateQuestion(Long id, QuestionBank question);
    void deleteQuestion(Long id);
}
