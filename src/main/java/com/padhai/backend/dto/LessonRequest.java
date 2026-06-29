package com.padhai.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LessonRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private String videoUrl;

    private Integer duration;

    @NotNull(message = "Lesson order is required")
    private Integer lessonOrder;

    @NotNull(message = "Course Id is required")
    private Long courseId;

    public LessonRequest() {
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getLessonOrder() {
        return lessonOrder;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setLessonOrder(Integer lessonOrder) {
        this.lessonOrder = lessonOrder;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}