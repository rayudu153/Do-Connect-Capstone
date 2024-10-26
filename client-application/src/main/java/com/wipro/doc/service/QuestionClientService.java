package com.wipro.doc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.doc.dto.QuestionBankDTO;

@Service
public class QuestionClientService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_API_URL = "http://localhost:8082/api/questions";

    // Method to get all questions as DTOs
    public List<QuestionBankDTO> getAllQuestions() {
        QuestionBankDTO[] questions = restTemplate.getForObject(BASE_API_URL, QuestionBankDTO[].class);
        return Arrays.asList(questions);
    }

    // Method to get a question by its ID
    public QuestionBankDTO getQuestionById(Long id) {
        String url = BASE_API_URL + "/" + id;
        return restTemplate.getForObject(url, QuestionBankDTO.class);
    }

    // Method to add a new question
    public QuestionBankDTO addQuestion(QuestionBankDTO newQuestion) {

		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setContentType(MediaType.APPLICATION_JSON);
		 * 
		 * HttpEntity<QuestionBankDTO> request = new HttpEntity<>(newQuestion, headers);
		 */
        
    	System.out.println("Service****" + newQuestion + "****************");
        return restTemplate.postForObject(BASE_API_URL, newQuestion, QuestionBankDTO.class);
    }

    // Method to update an existing question
    public void updateQuestion(Long id, QuestionBankDTO updatedQuestion) {
        String url = BASE_API_URL + "/" + id;
        restTemplate.put(url, updatedQuestion);
    }

    // Method to delete a question by its ID
    public void deleteQuestionById(Long id) {
        String url = BASE_API_URL + "/" + id;
        restTemplate.delete(url);
    }
    
    public List<QuestionBankDTO> searchQuestions(String term) {
        List<QuestionBankDTO> allQuestions = getAllQuestions(); // Ensure this retrieves all questions
        List<QuestionBankDTO> highlightedQuestions = new ArrayList<>();

        for (QuestionBankDTO question : allQuestions) {
            // Optionally highlight text here if needed in a property
            question.setQuestionText(
                question.getQuestionText().replaceAll("(?i)(" + Pattern.quote(term) + ")", "<span class='highlight'>$1</span>")
            );
            highlightedQuestions.add(question);
        }

        return highlightedQuestions;
    }
}
