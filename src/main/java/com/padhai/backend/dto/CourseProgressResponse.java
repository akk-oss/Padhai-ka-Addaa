package com.padhai.backend.dto;

public class CourseProgressResponse {

    private Long courseId;
    private String courseTitle;
    private long totalLessons;
    private long completedLessons;
    private double percentage;

    public CourseProgressResponse() {
    }

    public CourseProgressResponse(Long courseId,
                                  String courseTitle,
                                  long totalLessons,
                                  long completedLessons,
                                  double percentage) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.totalLessons = totalLessons;
        this.completedLessons = completedLessons;
        this.percentage = percentage;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public long getTotalLessons() {
        return totalLessons;
    }

    public long getCompletedLessons() {
        return completedLessons;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setTotalLessons(long totalLessons) {
        this.totalLessons = totalLessons;
    }

    public void setCompletedLessons(long completedLessons) {
        this.completedLessons = completedLessons;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}