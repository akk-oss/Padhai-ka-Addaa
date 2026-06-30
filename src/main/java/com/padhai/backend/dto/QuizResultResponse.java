package com.padhai.backend.dto;

import java.time.LocalDateTime;

public class QuizResultResponse {

    private Long attemptId;
    private String studentName;
    private String quizTitle;

    private Integer score;
    private Integer totalQuestions;
    private Double percentage;
    private Boolean passed;

    private LocalDateTime submittedAt;

    public QuizResultResponse() {
    }

    public QuizResultResponse(Long attemptId,
                              String studentName,
                              String quizTitle,
                              Integer score,
                              Integer totalQuestions,
                              Double percentage,
                              Boolean passed,
                              LocalDateTime submittedAt) {

        this.attemptId = attemptId;
        this.studentName = studentName;
        this.quizTitle = quizTitle;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.percentage = percentage;
        this.passed = passed;
        this.submittedAt = submittedAt;
    }

    public Long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(Long attemptId) {
        this.attemptId = attemptId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}