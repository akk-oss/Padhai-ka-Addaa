package com.padhai.backend.service;
import com.padhai.backend.dto.QuizResultResponse;
import com.padhai.backend.dto.QuizAttemptRequest;
import com.padhai.backend.dto.QuizAttemptResponse;
import com.padhai.backend.entity.Quiz;
import com.padhai.backend.entity.QuizAttempt;
import com.padhai.backend.entity.User;
import com.padhai.backend.exception.ResourceNotFoundException;
import com.padhai.backend.repository.QuizAttemptRepository;
import com.padhai.backend.repository.QuizRepository;
import com.padhai.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizAttemptService {

    private final QuizAttemptRepository quizAttemptRepository;
    private final UserRepository userRepository;
    private final QuizRepository quizRepository;

    public QuizAttemptService(QuizAttemptRepository quizAttemptRepository,
                              UserRepository userRepository,
                              QuizRepository quizRepository) {
        this.quizAttemptRepository = quizAttemptRepository;
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
    }

    // Start Quiz Attempt
    public QuizAttemptResponse startAttempt(QuizAttemptRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Quiz quiz = quizRepository.findById(request.getQuizId())
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));

        QuizAttempt attempt = new QuizAttempt();
        attempt.setUser(user);
        attempt.setQuiz(quiz);
        attempt.setScore(0);
        attempt.setTotalQuestions(0);

        QuizAttempt saved = quizAttemptRepository.save(attempt);

        return mapToResponse(saved);
    }

    // Get Attempt By ID
    public QuizAttemptResponse getAttemptById(Long id) {

        QuizAttempt attempt = quizAttemptRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz attempt not found"));

        return mapToResponse(attempt);
    }

    // Get User Attempts
    public List<QuizAttemptResponse> getUserAttempts(Long userId) {

        return quizAttemptRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Common Mapper
    private QuizAttemptResponse mapToResponse(QuizAttempt attempt) {

        return new QuizAttemptResponse(
                attempt.getId(),
                attempt.getUser().getId(),
                attempt.getUser().getFullName(),
                attempt.getQuiz().getId(),
                attempt.getQuiz().getTitle(),
                attempt.getScore(),
                attempt.getTotalQuestions(),
                attempt.getSubmittedAt()
        );
    }
    // Get Quiz Result
    public QuizResultResponse getQuizResult(Long attemptId) {

        QuizAttempt attempt = quizAttemptRepository.findById(attemptId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz Attempt not found"));

        double percentage = 0.0;

        if (attempt.getTotalQuestions() > 0) {
            percentage = ((double) attempt.getScore() / attempt.getTotalQuestions()) * 100;
        }

        boolean passed = percentage >= 40;

        return new QuizResultResponse(
                attempt.getId(),
                attempt.getUser().getFullName(),
                attempt.getQuiz().getTitle(),
                attempt.getScore(),
                attempt.getTotalQuestions(),
                percentage,
                passed,
                attempt.getSubmittedAt()
        );
    }
}