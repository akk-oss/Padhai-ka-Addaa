package com.padhai.backend.dto;

public class LessonResponse {

    private Long id;
    private String title;
    private String description;
    private String videoUrl;
    private Integer duration;
    private Integer lessonOrder;
    private Long courseId;
    private String courseTitle;

    public LessonResponse() {
    }

    public LessonResponse(Long id,
                          String title,
                          String description,
                          String videoUrl,
                          Integer duration,
                          Integer lessonOrder,
                          Long courseId,
                          String courseTitle) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.videoUrl = videoUrl;
        this.duration = duration;
        this.lessonOrder = lessonOrder;
        this.courseId = courseId;
        this.courseTitle = courseTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getLessonOrder() {
        return lessonOrder;
    }

    public void setLessonOrder(Integer lessonOrder) {
        this.lessonOrder = lessonOrder;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
}