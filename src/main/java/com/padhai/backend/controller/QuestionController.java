package com.padhai.backend.controller;

import com.padhai.backend.dto.QuestionRequest;
import com.padhai.backend.dto.QuestionResponse;
import com.padhai.backend.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // Create Question
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @PostMapping
    public QuestionResponse createQuestion(
            @Valid @RequestBody QuestionRequest request) {

        return questionService.createQuestion(request);
    }

    // Get Questions By Quiz
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER','STUDENT')")
    @GetMapping("/quiz/{quizId}")
    public List<QuestionResponse> getQuestionsByQuiz(
            @PathVariable Long quizId) {

        return questionService.getQuestionsByQuiz(quizId);
    }

    // Get Question By ID
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER','STUDENT')")
    @GetMapping("/{id}")
    public QuestionResponse getQuestionById(
            @PathVariable Long id) {

        return questionService.getQuestionById(id);
    }
    // Update Question
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @PutMapping("/{id}")
    public QuestionResponse updateQuestion(
            @PathVariable Long id,
            @Valid @RequestBody QuestionRequest request) {

        return questionService.updateQuestion(id, request);
    }

    // Delete Question
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Long id) {

        questionService.deleteQuestion(id);

        return "Question deleted successfully";
    }
}