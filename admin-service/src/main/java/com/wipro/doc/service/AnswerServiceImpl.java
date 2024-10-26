package com.wipro.doc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.doc.entity.Answer;
import com.wipro.doc.entity.QuestionBank;
import com.wipro.doc.exception.ResourceNotFoundException;
import com.wipro.doc.repository.AnswerRepository;
import com.wipro.doc.repository.QuestionBankRepository;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionBankRepository questionRepository;

    @Override
    public List<Answer> getAllAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer addAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer updateAnswer(Long id, Answer answer) {
        Answer existingAnswer = answerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Answer not found with id: " + id));

        // Update fields
        existingAnswer.setUser(answer.getUser());
        existingAnswer.setQuestion(answer.getQuestion());
        existingAnswer.setAnswerText(answer.getAnswerText());
        existingAnswer.setApproved(answer.isApproved());
        existingAnswer.setLikesCount(answer.getLikesCount());
        existingAnswer.setComment(answer.getComment());

        return answerRepository.save(existingAnswer);
    }

    @Override
    public void deleteAnswer(Long id) {
        if (!answerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Answer not found with id: " + id);
        }
        answerRepository.deleteById(id);
    }

    @Override
    public List<Answer> getAnswersByQuestionId(Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    @Override
    public Answer getAnswerById(Long id) {
        return answerRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Answer not found with id: " + id));
    }

    public Answer addAnswerToQuestion(Long questionId, Answer answer) {
        QuestionBank question = questionRepository.findById(questionId)
            .orElseThrow(() -> new ResourceNotFoundException("Question not found with id: " + questionId));

        answer.setQuestion(question);
        return answerRepository.save(answer);
    }
}