package com.padhai.backend.dto;

import java.time.LocalDateTime;

public class QuizAttemptResponse {

    private Long id;
    private Long userId;
    private String userName;
    private Long quizId;
    private String quizTitle;
    private Integer score;
    private Integer totalQuestions;
    private LocalDateTime submittedAt;

    public QuizAttemptResponse() {
    }

    public QuizAttemptResponse(Long id,
                               Long userId,
                               String userName,
                               Long quizId,
                               String quizTitle,
                               Integer score,
                               Integer totalQuestions,
                               LocalDateTime submittedAt) {

        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.quizId = quizId;
        this.quizTitle = quizTitle;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.submittedAt = submittedAt;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Long getQuizId() {
        return quizId;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}