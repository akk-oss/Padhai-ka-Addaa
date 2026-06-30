package com.padhai.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class QuizAnswerRequest {

    @NotNull(message = "Quiz Attempt ID is required")
    private Long quizAttemptId;

    @NotNull(message = "Question ID is required")
    private Long questionId;

    @NotBlank(message = "Selected answer is required")
    private String selectedAnswer;

    public QuizAnswerRequest() {
    }

    public Long getQuizAttemptId() {
        return quizAttemptId;
    }

    public void setQuizAttemptId(Long quizAttemptId) {
        this.quizAttemptId = quizAttemptId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}