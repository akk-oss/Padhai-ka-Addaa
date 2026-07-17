package com.padhai.backend.dto;

public class AdminDashboardResponse {

    private Long totalStudents;
    private Long totalTeachers;
    private Long totalCategories;
    private Long totalCourses;
    private Long totalLessons;
    private Long totalEnrollments;
    private Long totalQuizzes;
    private Long totalQuestions;
    private Long totalQuizAttempts;

    public AdminDashboardResponse() {
    }

    public AdminDashboardResponse(Long totalStudents,
                                  Long totalTeachers,
                                  Long totalCategories,
                                  Long totalCourses,
                                  Long totalLessons,
                                  Long totalEnrollments,
                                  Long totalQuizzes,
                                  Long totalQuestions,
                                  Long totalQuizAttempts) {

        this.totalStudents = totalStudents;
        this.totalTeachers = totalTeachers;
        this.totalCategories = totalCategories;
        this.totalCourses = totalCourses;
        this.totalLessons = totalLessons;
        this.totalEnrollments = totalEnrollments;
        this.totalQuizzes = totalQuizzes;
        this.totalQuestions = totalQuestions;
        this.totalQuizAttempts = totalQuizAttempts;
    }

    public Long getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(Long totalStudents) {
        this.totalStudents = totalStudents;
    }

    public Long getTotalTeachers() {
        return totalTeachers;
    }

    public void setTotalTeachers(Long totalTeachers) {
        this.totalTeachers = totalTeachers;
    }

    public Long getTotalCategories() {
        return totalCategories;
    }

    public void setTotalCategories(Long totalCategories) {
        this.totalCategories = totalCategories;
    }

    public Long getTotalCourses() {
        return totalCourses;
    }

    public void setTotalCourses(Long totalCourses) {
        this.totalCourses = totalCourses;
    }

    public Long getTotalLessons() {
        return totalLessons;
    }

    public void setTotalLessons(Long totalLessons) {
        this.totalLessons = totalLessons;
    }

    public Long getTotalEnrollments() {
        return totalEnrollments;
    }

    public void setTotalEnrollments(Long totalEnrollments) {
        this.totalEnrollments = totalEnrollments;
    }

    public Long getTotalQuizzes() {
        return totalQuizzes;
    }

    public void setTotalQuizzes(Long totalQuizzes) {
        this.totalQuizzes = totalQuizzes;
    }

    public Long getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Long totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Long getTotalQuizAttempts() {
        return totalQuizAttempts;
    }

    public void setTotalQuizAttempts(Long totalQuizAttempts) {
        this.totalQuizAttempts = totalQuizAttempts;
    }
}