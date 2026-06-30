package com.padhai.backend.controller;
import com.padhai.backend.dto.QuizResultResponse;
import com.padhai.backend.dto.QuizAttemptRequest;
import com.padhai.backend.dto.QuizAttemptResponse;
import com.padhai.backend.service.QuizAttemptService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz-attempts")
public class QuizAttemptController {

    private final QuizAttemptService quizAttemptService;

    public QuizAttemptController(QuizAttemptService quizAttemptService) {
        this.quizAttemptService = quizAttemptService;
    }

    // Start Quiz Attempt
    @PostMapping("/start")
    public QuizAttemptResponse startAttempt(
            @Valid @RequestBody QuizAttemptRequest request) {

        return quizAttemptService.startAttempt(request);
    }

    // Get Attempt By ID
    @GetMapping("/{id}")
    public QuizAttemptResponse getAttemptById(@PathVariable Long id) {

        return quizAttemptService.getAttemptById(id);
    }

    // Get User Attempts
    @GetMapping("/user/{userId}")
    public List<QuizAttemptResponse> getUserAttempts(
            @PathVariable Long userId) {

        return quizAttemptService.getUserAttempts(userId);
    }
    // Get Quiz Result
    @GetMapping("/{attemptId}/result")
    public QuizResultResponse getQuizResult(
            @PathVariable Long attemptId) {

        return quizAttemptService.getQuizResult(attemptId);
    }
}