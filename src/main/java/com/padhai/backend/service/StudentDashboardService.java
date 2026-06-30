package com.padhai.backend.service;

import com.padhai.backend.dto.StudentDashboardResponse;
import com.padhai.backend.entity.QuizAttempt;
import com.padhai.backend.entity.User;
import com.padhai.backend.exception.ResourceNotFoundException;
import com.padhai.backend.repository.EnrollmentRepository;
import com.padhai.backend.repository.LessonProgressRepository;
import com.padhai.backend.repository.QuizAttemptRepository;
import com.padhai.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDashboardService {

    private final UserRepository userRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final LessonProgressRepository lessonProgressRepository;
    private final QuizAttemptRepository quizAttemptRepository;

    public StudentDashboardService(
            UserRepository userRepository,
            EnrollmentRepository enrollmentRepository,
            LessonProgressRepository lessonProgressRepository,
            QuizAttemptRepository quizAttemptRepository) {

        this.userRepository = userRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.lessonProgressRepository = lessonProgressRepository;
        this.quizAttemptRepository = quizAttemptRepository;
    }

    public StudentDashboardResponse getDashboard(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        int totalEnrolledCourses =
                (int) enrollmentRepository.countByUserId(userId);

        int completedLessons =
                (int) lessonProgressRepository.countByUserIdAndCompletedTrue(userId);

        List<QuizAttempt> attempts =
                quizAttemptRepository.findByUserId(userId);

        int totalQuizAttempts = attempts.size();

        double averageQuizScore = 0;

        if (!attempts.isEmpty()) {

            averageQuizScore = attempts.stream()
                    .mapToInt(QuizAttempt::getScore)
                    .average()
                    .orElse(0);
        }

        return new StudentDashboardResponse(
                user.getFullName(),
                totalEnrolledCourses,
                completedLessons,
                totalQuizAttempts,
                averageQuizScore
        );
    }
}