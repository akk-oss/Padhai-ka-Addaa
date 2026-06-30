package com.padhai.backend.dto;

public class QuizAnswerResponse {

    private Long id;
    private Long questionId;
    private String questionText;
    private String selectedAnswer;
    private boolean correct;

    public QuizAnswerResponse() {
    }

    public QuizAnswerResponse(Long id,
                              Long questionId,
                              String questionText,
                              String selectedAnswer,
                              boolean correct) {

        this.id = id;
        this.questionId = questionId;
        this.questionText = questionText;
        this.selectedAnswer = selectedAnswer;
        this.correct = correct;
    }

    public Long getId() {
        return id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}