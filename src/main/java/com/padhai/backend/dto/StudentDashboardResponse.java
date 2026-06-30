package com.padhai.backend.dto;

public class StudentDashboardResponse {

    private String studentName;
    private Integer totalEnrolledCourses;
    private Integer completedLessons;
    private Integer totalQuizAttempts;
    private Double averageQuizScore;

    public StudentDashboardResponse() {
    }

    public StudentDashboardResponse(String studentName,
                                    Integer totalEnrolledCourses,
                                    Integer completedLessons,
                                    Integer totalQuizAttempts,
                                    Double averageQuizScore) {

        this.studentName = studentName;
        this.totalEnrolledCourses = totalEnrolledCourses;
        this.completedLessons = completedLessons;
        this.totalQuizAttempts = totalQuizAttempts;
        this.averageQuizScore = averageQuizScore;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getTotalEnrolledCourses() {
        return totalEnrolledCourses;
    }

    public Integer getCompletedLessons() {
        return completedLessons;
    }

    public Integer getTotalQuizAttempts() {
        return totalQuizAttempts;
    }

    public Double getAverageQuizScore() {
        return averageQuizScore;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setTotalEnrolledCourses(Integer totalEnrolledCourses) {
        this.totalEnrolledCourses = totalEnrolledCourses;
    }

    public void setCompletedLessons(Integer completedLessons) {
        this.completedLessons = completedLessons;
    }

    public void setTotalQuizAttempts(Integer totalQuizAttempts) {
        this.totalQuizAttempts = totalQuizAttempts;
    }

    public void setAverageQuizScore(Double averageQuizScore) {
        this.averageQuizScore = averageQuizScore;
    }
}