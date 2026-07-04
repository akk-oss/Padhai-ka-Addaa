package com.padhai.backend.dto;

import java.time.LocalDateTime;

public class EnrollmentResponse {

    private Long id;
    private Long userId;
    private String userName;
    private Long courseId;
    private String courseTitle;
    private LocalDateTime enrolledAt;

    public EnrollmentResponse() {
    }

    public EnrollmentResponse(Long id,
                              Long userId,
                              String userName,
                              Long courseId,
                              String courseTitle,
                              String thumbnailUrl,
                              LocalDateTime enrolledAt) {

        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.thumbnailUrl = thumbnailUrl;
        this.enrolledAt = enrolledAt;
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

    public Long getCourseId() {
        return courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
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

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }

private String thumbnailUrl;

public String getThumbnailUrl() {
    return thumbnailUrl;
}

public void setThumbnailUrl(String thumbnailUrl) {
    this.thumbnailUrl = thumbnailUrl;
}}