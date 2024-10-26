package com.wipro.doc.service;

import java.util.List;

import com.wipro.doc.entity.Answer;

public interface AnswerService {

    List<Answer> getAllAnswers();

    Answer addAnswer(Answer answer);

    Answer updateAnswer(Long id, Answer answer);

    void deleteAnswer(Long id);

    List<Answer> getAnswersByQuestionId(Long questionId);

    Answer getAnswerById(Long id);

    // Add this method signature
    Answer addAnswerToQuestion(Long questionId, Answer answer);
}
