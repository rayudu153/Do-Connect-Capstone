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

import com.wipro.doc.dto.DoConnectUserDTO;
import com.wipro.doc.dto.QuestionBankDTO;
import com.wipro.doc.service.ClientService;
import com.wipro.doc.service.QuestionClientService;

@Controller
public class QuestionBankClientController {

    @Autowired
    private QuestionClientService questionService;

    @Autowired
    private ClientService userService;

//    // Display all questions
//    @GetMapping("/questions")
//    public String showAllQuestions(Model model) {
//        List<QuestionBankDTO> questionDTOs = questionService.getAllQuestions();
//        model.addAttribute("questions", questionDTOs);
//        return "manageQuestions";
//    }
    
    @GetMapping("/questions")
    public String showAllQuestions(Model model) {
        List<QuestionBankDTO> questionDTOs = questionService.getAllQuestions();
        
        // Log to check if usernames are present
        questionDTOs.forEach(question -> {
            System.out.println("Question ID: " + question.getId() + ", Username: " + 
                (question.getUser() != null ? question.getUser().getUsername() : "No User"));
        });
        
        model.addAttribute("questions", questionDTOs);
        return "manageQuestions";
    }


    // Show the page to create a new question
    @GetMapping("/questions/create")
    public String showCreateQuestionPage(Model model) {
        model.addAttribute("question", new QuestionBankDTO());
        return "createQuestion";
    }

    @PostMapping("/questions/create")
    public String createQuestion(@ModelAttribute QuestionBankDTO question) {
        Long userId = 1L;
        DoConnectUserDTO userDTO = userService.getUserById(userId);

        if (userDTO == null) {
            System.out.println("User not found with ID: " + userId);
            return "redirect:/error";
        }

        question.setUser(userDTO);
        
        questionService.addQuestion(question);
        
        return "redirect:/questions";
    }

    // Show the edit page for a question
    @GetMapping("/questions/edit/{id}")
    public String editQuestion(@PathVariable Long id, Model model) { 
        QuestionBankDTO questionDTO = questionService.getQuestionById(id);
        model.addAttribute("question", questionDTO);
        return "editQuestion";
    }

    // Handle updating a question
    @PostMapping("/questions/update/{id}")
    public String updateQuestion(
            @PathVariable Long id,
            @RequestParam(defaultValue = "1") Long userId, // Hardcoded user ID for update as well
            @RequestParam String questionText,
            @RequestParam String topic,
            @RequestParam(defaultValue = "false") boolean approved,
            @RequestParam(defaultValue = "ACTIVE") String status,
            Model model) {
        
        DoConnectUserDTO userDTO = userService.getUserById(userId);

        if (userDTO == null) {
            return "redirect:/error"; // Handle user not found case
        }

        QuestionBankDTO questionDTO = new QuestionBankDTO();
        questionDTO.setId(id);
        questionDTO.setUser(userDTO);
        questionDTO.setQuestionText(questionText);
        questionDTO.setTopic(topic);
        questionDTO.setApproved(approved);
        questionDTO.setStatus(status);
        
        questionService.updateQuestion(id, questionDTO); // Pass id here for clarity
        return "redirect:/questions"; // Redirect to the questions list after update
    }

    // View a question's details
    @GetMapping("/questions/view/{id}")
    public String viewQuestion(@PathVariable Long id, Model model) { 
        QuestionBankDTO questionDTO = questionService.getQuestionById(id);
        model.addAttribute("question", questionDTO);
        return "viewQuestion";
    }

    // Handle deleting a question
    @GetMapping("/questions/delete/{id}")
    public String deleteQuestion(@PathVariable Long id) { 
        questionService.deleteQuestionById(id);
        return "redirect:/questions";
    }
    
    @GetMapping("/questions/search")
    public String searchQuestions(@RequestParam("term") String searchTerm, Model model) {
        List<QuestionBankDTO> highlightedQuestions = questionService.searchQuestions(searchTerm);
        model.addAttribute("questions", highlightedQuestions); // Now this is a List<QuestionBankDTO>
        model.addAttribute("searchTerm", searchTerm); // Pass the search term for further use if needed
        return "manageQuestions"; // Ensure this points to your JSP
    }
}
