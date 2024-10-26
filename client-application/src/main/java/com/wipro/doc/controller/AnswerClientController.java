package com.wipro.doc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.doc.dto.AnswerDTO;
import com.wipro.doc.dto.DoConnectUserDTO;
import com.wipro.doc.dto.QuestionBankDTO;
import com.wipro.doc.service.AnswerClientService;
import com.wipro.doc.service.ClientService;
import com.wipro.doc.service.QuestionClientService;

@Controller
public class AnswerClientController {

    @Autowired
    private AnswerClientService answerService;

    @Autowired
    private QuestionClientService questionService;
    
    @Autowired
    private ClientService userService;

    @GetMapping("/answers")
    public String showAllAnswers(Model model) {
        List<AnswerDTO> answers = answerService.getAllAnswers();
        model.addAttribute("answers", answers);
        return "manageAnswers"; // Returns the manage answers JSP page
    }

    @GetMapping("/answers/create/{questionId}")
    public String showCreateAnswerPage(@PathVariable Long questionId, Model model) {
        QuestionBankDTO question = questionService.getQuestionById(questionId);
        model.addAttribute("question", question);
        model.addAttribute("answer", new AnswerDTO());
        return "createAnswer"; // Returns the create answer JSP page
    }

    @PostMapping("/answers/create/{questionId}")
    public String createAnswer(@PathVariable Long questionId, @ModelAttribute AnswerDTO answerDTO) {
        QuestionBankDTO question = new QuestionBankDTO();
        question.setId(questionId); // Set the question ID from the path variable
        answerDTO.setQuestion(question); // Set the QuestionBankDTO in AnswerDTO
        
        // Set the user information
        DoConnectUserDTO user = new DoConnectUserDTO();
        user.setId(1L); // Set the user ID, change as needed
        answerDTO.setUser(user); // Set the DoConnectUserDTO in AnswerDTO

        // Call the service to save the answer
        answerService.addAnswer(answerDTO);
        
        return "redirect:/questions"; // Redirect to questions page after submission
    }
    
    @GetMapping("/answers/{questionId}")
    public String viewAnswersByQuestion(@PathVariable Long questionId, Model model) {
        QuestionBankDTO question = questionService.getQuestionById(questionId);
        List<AnswerDTO> answers = answerService.getAllAnswersForQuestion(questionId); // Assuming this method exists

        model.addAttribute("question", question);
        model.addAttribute("answers", answers);
        
        return "viewAnswer"; // Returns the view answer JSP page
    }
    
    @GetMapping("/answers/edit/{id}")
    public String editAnswer(@PathVariable Long id, Model model) {
        // Fetch the answer DTO by ID
        AnswerDTO answerDTO = answerService.getAnswerById(id);
        
        // Check if answer exists
        if (answerDTO == null) {
            return "redirect:/error"; // Handle answer not found case
        }

        model.addAttribute("answer", answerDTO);
        
        // Add user ID and question ID to the model
        if (answerDTO.getUser() != null) {
            model.addAttribute("userId", answerDTO.getUser().getId());
        } else {
            model.addAttribute("userId", null); // or handle appropriately
        }

        if (answerDTO.getQuestion() != null) {
            model.addAttribute("questionId", answerDTO.getQuestion().getId());
        } else {
            model.addAttribute("questionId", null); // or handle appropriately
        }
        
        return "editAnswer"; // Returns the edit answer JSP page
    }

    @PostMapping("/answers/update/{id}")
    public String updateAnswer(
            @PathVariable Long id,
            @RequestParam(defaultValue = "1") Long userId, // Get user ID from request
            @RequestParam Long questionId, // Get question ID from request
            @RequestParam String answerText,
            @RequestParam(defaultValue = "false") boolean approved,
            @RequestParam(defaultValue = "0") int likesCount, // Default likes count if not provided
            @RequestParam(required = false) String comment, // Comment is optional
            Model model) {
        
        // Fetch user by ID
        DoConnectUserDTO userDTO = userService.getUserById(userId);
        if (userDTO == null) {
            return "redirect:/error"; // Handle user not found case
        }

        // Fetch question by ID
        QuestionBankDTO questionDTO = questionService.getQuestionById(questionId);
        if (questionDTO == null) {
            return "redirect:/error"; // Handle question not found case
        }

        // Create AnswerDTO and set its properties
        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setId(id); // Set the ID of the answer to update
        answerDTO.setUser(userDTO); // Set the user
        answerDTO.setQuestion(questionDTO); // Set the question
        answerDTO.setAnswerText(answerText); // Set the answer text
        answerDTO.setApproved(approved); // Set the approval status
        answerDTO.setLikesCount(likesCount); // Set the likes count
        answerDTO.setComment(comment); // Set the comment (optional)

        // Update the answer using the service
        answerService.updateAnswer(id, answerDTO);

        return "redirect:/answers"; // Redirect to the answers list after update
    }


    @GetMapping("/answers/view/{id}")
    public String viewAnswer(@PathVariable Long id, Model model) {
        AnswerDTO answerDTO = answerService.getAnswerById(id);
        model.addAttribute("answer", answerDTO);
        return "viewAnswer"; // Returns the view answer JSP page
    }

    @GetMapping("/answers/delete/{id}")
    public String deleteAnswer(@PathVariable Long id) {
        answerService.deleteAnswerById(id);
        return "redirect:/answers"; // Redirect back to the manage answers page after deletion
    }
}
