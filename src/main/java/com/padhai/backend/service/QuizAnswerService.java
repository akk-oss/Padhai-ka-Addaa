package com.padhai.backend.service;

import com.padhai.backend.dto.QuizAnswerRequest;
import com.padhai.backend.dto.QuizAnswerResponse;
import com.padhai.backend.entity.Question;
import com.padhai.backend.entity.QuizAnswer;
import com.padhai.backend.entity.QuizAttempt;
import com.padhai.backend.exception.ResourceNotFoundException;
import com.padhai.backend.repository.QuestionRepository;
import com.padhai.backend.repository.QuizAnswerRepository;
import com.padhai.backend.repository.QuizAttemptRepository;
import org.springframework.stereotype.Service;

@Service
public class QuizAnswerService {

    private final QuizAnswerRepository quizAnswerRepository;
    private final QuizAttemptRepository quizAttemptRepository;
    private final QuestionRepository questionRepository;

    public QuizAnswerService(
            QuizAnswerRepository quizAnswerRepository,
            QuizAttemptRepository quizAttemptRepository,
            QuestionRepository questionRepository) {

        this.quizAnswerRepository = quizAnswerRepository;
        this.quizAttemptRepository = quizAttemptRepository;
        this.questionRepository = questionRepository;
    }

    public QuizAnswerResponse submitAnswer(QuizAnswerRequest request) {

        QuizAttempt attempt = quizAttemptRepository.findById(request.getQuizAttemptId())
                .orElseThrow(() -> new ResourceNotFoundException("Quiz Attempt not found"));

        Question question = questionRepository.findById(request.getQuestionId())
                .orElseThrow(() -> new ResourceNotFoundException("Question not found"));

        boolean correct = question.getCorrectAnswer()
                .equalsIgnoreCase(request.getSelectedAnswer());

        QuizAnswer answer = new QuizAnswer();
        answer.setQuizAttempt(attempt);
        answer.setQuestion(question);
        answer.setSelectedAnswer(request.getSelectedAnswer());
        answer.setCorrect(correct);

        QuizAnswer saved = quizAnswerRepository.save(answer);

        // Update Attempt Score
        if (correct) {
            attempt.setScore(attempt.getScore() + 1);
        }

        attempt.setTotalQuestions(attempt.getTotalQuestions() + 1);

        quizAttemptRepository.save(attempt);

        return new QuizAnswerResponse(
                saved.getId(),
                question.getId(),
                question.getQuestionText(),
                saved.getSelectedAnswer(),
                saved.isCorrect()
        );
    }
}