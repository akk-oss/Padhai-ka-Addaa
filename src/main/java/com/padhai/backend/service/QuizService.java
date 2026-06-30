package com.padhai.backend.service;

import com.padhai.backend.dto.QuizRequest;
import com.padhai.backend.dto.QuizResponse;
import com.padhai.backend.entity.Course;
import com.padhai.backend.entity.Quiz;
import com.padhai.backend.exception.ResourceNotFoundException;
import com.padhai.backend.repository.CourseRepository;
import com.padhai.backend.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final CourseRepository courseRepository;

    public QuizService(QuizRepository quizRepository,
                       CourseRepository courseRepository) {
        this.quizRepository = quizRepository;
        this.courseRepository = courseRepository;
    }

    // Create Quiz
    public QuizResponse createQuiz(QuizRequest request) {

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        Quiz quiz = new Quiz();
        quiz.setTitle(request.getTitle());
        quiz.setCourse(course);

        Quiz saved = quizRepository.save(quiz);

        return new QuizResponse(
                saved.getId(),
                saved.getTitle(),
                course.getId(),
                course.getTitle()
        );
    }

    // Get All Quizzes
    public List<QuizResponse> getAllQuizzes() {

        return quizRepository.findAll()
                .stream()
                .map(quiz -> new QuizResponse(
                        quiz.getId(),
                        quiz.getTitle(),
                        quiz.getCourse().getId(),
                        quiz.getCourse().getTitle()
                ))
                .collect(Collectors.toList());
    }

    // Get Quiz By ID
    public QuizResponse getQuizById(Long id) {

        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));

        return new QuizResponse(
                quiz.getId(),
                quiz.getTitle(),
                quiz.getCourse().getId(),
                quiz.getCourse().getTitle()
        );
    }
}