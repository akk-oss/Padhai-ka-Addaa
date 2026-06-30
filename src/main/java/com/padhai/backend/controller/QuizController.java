package com.padhai.backend.controller;

import com.padhai.backend.dto.QuizRequest;
import com.padhai.backend.dto.QuizResponse;
import com.padhai.backend.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    // Create Quiz
    @PostMapping
    public QuizResponse createQuiz(@Valid @RequestBody QuizRequest request) {
        return quizService.createQuiz(request);
    }

    // Get All Quizzes
    @GetMapping
    public List<QuizResponse> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    // Get Quiz By ID
    @GetMapping("/{id}")
    public QuizResponse getQuizById(@PathVariable Long id) {
        return quizService.getQuizById(id);
    }
}