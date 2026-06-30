package com.padhai.backend.dto;

public class QuizResponse {

    private Long id;
    private String title;
    private Long courseId;
    private String courseTitle;

    public QuizResponse() {
    }

    public QuizResponse(Long id,
                        String title,
                        Long courseId,
                        String courseTitle) {

        this.id = id;
        this.title = title;
        this.courseId = courseId;
        this.courseTitle = courseTitle;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
}