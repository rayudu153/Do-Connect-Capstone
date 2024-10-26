package com.wipro.doc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class DoConnectUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Username is required")
    @Column(nullable = false, unique = true)
    private String username;

    @NotEmpty(message = "Password is required")
    @Column(nullable = false)
    private String password;

    @NotEmpty(message = "Email is required")
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstName;
    
    private String lastName;

    @Column(nullable = false)
    private String role; // ADMIN or USER

    @Column(nullable = false)
    private boolean active = true;

//    @OneToMany(mappedBy = "user")
//    @JsonManagedReference("user-questions")
//    private List<QuestionBank> questions;
//    
//    @OneToMany(mappedBy = "user")
//    @JsonManagedReference("user-answers")
//    private List<Answer> answers;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

//    public List<QuestionBank> getQuestions() {
//        return questions;
//    }
//
//    public void setQuestions(List<QuestionBank> questions) {
//        this.questions = questions;
//    }
//
//    public List<Answer> getAnswers() {
//        return answers;
//    }
//
//    public void setAnswers(List<Answer> answers) {
//        this.answers = answers;
//    }

}
