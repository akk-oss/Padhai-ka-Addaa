package com.padhai.backend.controller;

import com.padhai.backend.dto.QuizAnswerRequest;
import com.padhai.backend.dto.QuizAnswerResponse;
import com.padhai.backend.service.QuizAnswerService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz-answers")
public class QuizAnswerController {

    private final QuizAnswerService quizAnswerService;

    public QuizAnswerController(QuizAnswerService quizAnswerService) {
        this.quizAnswerService = quizAnswerService;
    }

    // Submit Answer
    @PreAuthorize("hasAnyRole('ADMIN','STUDENT')")
    @PostMapping
    public QuizAnswerResponse submitAnswer(
            @Valid @RequestBody QuizAnswerRequest request) {

        return quizAnswerService.submitAnswer(request);
    }
}