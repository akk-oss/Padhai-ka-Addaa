package com.padhai.backend.dto;

import java.time.LocalDateTime;

public class LessonProgressResponse {

    private Long id;
    private Long userId;
    private String userName;
    private Long lessonId;
    private String lessonTitle;
    private boolean completed;
    private LocalDateTime completedAt;

    public LessonProgressResponse() {
    }

    public LessonProgressResponse(Long id,
                                  Long userId,
                                  String userName,
                                  Long lessonId,
                                  String lessonTitle,
                                  boolean completed,
                                  LocalDateTime completedAt) {

        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.lessonId = lessonId;
        this.lessonTitle = lessonTitle;
        this.completed = completed;
        this.completedAt = completedAt;
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

    public Long getLessonId() {
        return lessonId;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
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

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }
}