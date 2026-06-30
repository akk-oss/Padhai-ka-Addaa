package com.padhai.backend.dto;

import jakarta.validation.constraints.NotNull;

public class QuizAttemptRequest {

    @NotNull(message = "User ID is required")
    private Long userId;

    @NotNull(message = "Quiz ID is required")
    private Long quizId;

    public QuizAttemptRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }
}