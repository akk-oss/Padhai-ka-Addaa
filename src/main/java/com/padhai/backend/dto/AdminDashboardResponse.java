package com.padhai.backend.dto;

public class AdminDashboardResponse {

    private Long totalUsers;
    private Long totalCategories;
    private Long totalCourses;
    private Long totalLessons;
    private Long totalEnrollments;
    private Long totalQuizzes;
    private Long totalQuestions;
    private Long totalQuizAttempts;

    public AdminDashboardResponse() {
    }

    public AdminDashboardResponse(Long totalUsers,
                                  Long totalCategories,
                                  Long totalCourses,
                                  Long totalLessons,
                                  Long totalEnrollments,
                                  Long totalQuizzes,
                                  Long totalQuestions,
                                  Long totalQuizAttempts) {

        this.totalUsers = totalUsers;
        this.totalCategories = totalCategories;
        this.totalCourses = totalCourses;
        this.totalLessons = totalLessons;
        this.totalEnrollments = totalEnrollments;
        this.totalQuizzes = totalQuizzes;
        this.totalQuestions = totalQuestions;
        this.totalQuizAttempts = totalQuizAttempts;
    }

    public Long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(Long totalUsers) {
        this.totalUsers = totalUsers;
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