package com.padhai.backend.dto;

public class LessonProgressRequest {

    private Long userId;
    private Long lessonId;

    public LessonProgressRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }
}