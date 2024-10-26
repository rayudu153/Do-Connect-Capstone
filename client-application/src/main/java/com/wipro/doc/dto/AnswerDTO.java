package com.wipro.doc.dto;

public class AnswerDTO {
    @Override
	public String toString() {
		return "AnswerDTO [id=" + id + ", answerText=" + answerText + ", question=" + question + ", user=" + user
				+ ", approved=" + approved + ", likesCount=" + likesCount + ", comment=" + comment + "]";
	}

	private Long id;
    private String answerText;
    private QuestionBankDTO question; // Updated to include QuestionBankDTO
    private DoConnectUserDTO user; // Updated to include DoConnectUserDTO
    private boolean approved;
    private int likesCount;
    private String comment;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public QuestionBankDTO getQuestion() {
        return question;
    }

    public void setQuestion(QuestionBankDTO question) {
        this.question = question;
    }

    public DoConnectUserDTO getUser() {
        return user;
    }

    public void setUser(DoConnectUserDTO user) {
        this.user = user;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
