package com.wipro.doc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.doc.dto.AnswerDTO;
import com.wipro.doc.dto.QuestionBankDTO;

@Service
public class AnswerClientService {
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private QuestionClientService questionService;
    
    private static final String BASE_API_URL = "http://localhost:8082/api";
    
    public List<AnswerDTO> getAllAnswers() {
        AnswerDTO[] answers = restTemplate.getForObject(BASE_API_URL + "/answers", AnswerDTO[].class);
        return Arrays.asList(answers);
    }
    
    public AnswerDTO addAnswer(AnswerDTO answerDTO) {
        String url = BASE_API_URL + "/answers/create/" + answerDTO.getQuestion().getId(); // Update to use question DTO
        return restTemplate.postForObject(url, answerDTO, AnswerDTO.class);
    }
    
//    public void updateAnswer(Long id, AnswerDTO answerDTO) {
//        String url = BASE_API_URL + "/answers/" + id;
//        restTemplate.put(url, answerDTO);
//    }
    
    public void updateAnswer(Long id, AnswerDTO answerDTO) {
        String url = BASE_API_URL + "/answers/" + id;
        QuestionBankDTO question = questionService.getQuestionById(answerDTO.getQuestion().getId());
        answerDTO.setQuestion(question);

        restTemplate.put(url, answerDTO);
    }
    
    public void deleteAnswerById(Long id) {
        String url = BASE_API_URL + "/answers/" + id;
        restTemplate.delete(url);
    }
    
    public List<AnswerDTO> getAllAnswersForQuestion(Long questionId) {
        AnswerDTO[] answers = restTemplate.getForObject(BASE_API_URL + "/answers/question/" + questionId, AnswerDTO[].class);
        return Arrays.asList(answers);
    }
    
    public AnswerDTO getAnswerById(Long id) {
        String url = BASE_API_URL + "/answers/" + id;
        AnswerDTO answerDTO = restTemplate.getForObject(url, AnswerDTO.class);
        return answerDTO;
    }
    
    public Long getQuestionIdForAnswer(Long answerId) {
        AnswerDTO answerDTO = getAnswerById(answerId);
        return answerDTO.getQuestion().getId();
    }

}
