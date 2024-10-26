package com.wipro.doc.dto;

import java.util.List;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionBankDTO {
    private Long id;
    private DoConnectUserDTO user; // Represents the user who posted the question
    private String questionText;
    private String topic;
    private boolean approved;
    private String status; // e.g., ACTIVE, CLOSED
    private List<AnswerDTO> answers; // List of answers to the question
//    private LocalDateTime createdAt;

    // Default constructor
    public QuestionBankDTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DoConnectUserDTO getUser() {
		return user;
	}

	public void setUser(DoConnectUserDTO user) {
		this.user = user;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<AnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerDTO> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "QuestionBankDTO [id=" + id + ", user=" + user + ", questionText=" + questionText + ", topic=" + topic
				+ ", approved=" + approved + ", status=" + status + ", answers=" + answers + "]";
	}



}
