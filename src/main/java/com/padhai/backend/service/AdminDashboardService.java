package com.padhai.backend.service;

import com.padhai.backend.dto.AdminDashboardResponse;
import com.padhai.backend.repository.*;
import org.springframework.stereotype.Service;

@Service
public class AdminDashboardService {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final CourseRepository courseRepository;
    private final LessonRepository lessonRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final QuizAttemptRepository quizAttemptRepository;

    public AdminDashboardService(
            UserRepository userRepository,
            CategoryRepository categoryRepository,
            CourseRepository courseRepository,
            LessonRepository lessonRepository,
            EnrollmentRepository enrollmentRepository,
            QuizRepository quizRepository,
            QuestionRepository questionRepository,
            QuizAttemptRepository quizAttemptRepository) {

        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.quizAttemptRepository = quizAttemptRepository;
    }

    public AdminDashboardResponse getDashboard() {

        return new AdminDashboardResponse(
                userRepository.count(),
                categoryRepository.count(),
                courseRepository.count(),
                lessonRepository.count(),
                enrollmentRepository.count(),
                quizRepository.count(),
                questionRepository.count(),
                quizAttemptRepository.count()
        );
    }
}