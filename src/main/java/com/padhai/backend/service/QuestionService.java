package com.padhai.backend.service;

import com.padhai.backend.dto.QuestionRequest;
import com.padhai.backend.dto.QuestionResponse;
import com.padhai.backend.entity.Question;
import com.padhai.backend.entity.Quiz;
import com.padhai.backend.exception.ResourceNotFoundException;
import com.padhai.backend.repository.QuestionRepository;
import com.padhai.backend.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    public QuestionService(QuestionRepository questionRepository,
                           QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    // Create Question
    public QuestionResponse createQuestion(QuestionRequest request) {

        Quiz quiz = quizRepository.findById(request.getQuizId())
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));

        Question question = new Question();
        question.setQuestionText(request.getQuestionText());
        question.setOptionA(request.getOptionA());
        question.setOptionB(request.getOptionB());
        question.setOptionC(request.getOptionC());
        question.setOptionD(request.getOptionD());
        question.setCorrectAnswer(request.getCorrectAnswer());
        question.setQuiz(quiz);

        Question saved = questionRepository.save(question);

        return mapToResponse(saved);
    }

    // Get Questions By Quiz
    public List<QuestionResponse> getQuestionsByQuiz(Long quizId) {

        return questionRepository.findByQuizId(quizId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // Get Question By ID
    public QuestionResponse getQuestionById(Long id) {

        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found"));

        return mapToResponse(question);
    }
    // Update Question
    public QuestionResponse updateQuestion(Long id, QuestionRequest request) {

        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found"));

        Quiz quiz = quizRepository.findById(request.getQuizId())
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));

        question.setQuestionText(request.getQuestionText());
        question.setOptionA(request.getOptionA());
        question.setOptionB(request.getOptionB());
        question.setOptionC(request.getOptionC());
        question.setOptionD(request.getOptionD());
        question.setCorrectAnswer(request.getCorrectAnswer());
        question.setQuiz(quiz);

        Question updated = questionRepository.save(question);

        return mapToResponse(updated);
    }
    // Delete Question
    public void deleteQuestion(Long id) {

        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question not found"));

        questionRepository.delete(question);
    }

    // Common Mapper
    private QuestionResponse mapToResponse(Question question) {

        return new QuestionResponse(
                question.getId(),
                question.getQuestionText(),
                question.getOptionA(),
                question.getOptionB(),
                question.getOptionC(),
                question.getOptionD(),
                question.getCorrectAnswer(),
                question.getQuiz().getId(),
                question.getQuiz().getTitle()
        );
    }
}