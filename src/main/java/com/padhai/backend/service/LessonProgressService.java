package com.padhai.backend.service;
import com.padhai.backend.dto.CourseProgressResponse;
import com.padhai.backend.entity.Course;
import com.padhai.backend.dto.LessonProgressRequest;
import com.padhai.backend.dto.LessonProgressResponse;
import com.padhai.backend.entity.Lesson;
import com.padhai.backend.entity.LessonProgress;
import com.padhai.backend.entity.User;
import com.padhai.backend.exception.DuplicateResourceException;
import com.padhai.backend.exception.ResourceNotFoundException;
import com.padhai.backend.repository.LessonProgressRepository;
import com.padhai.backend.repository.LessonRepository;
import com.padhai.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonProgressService {

    private final LessonProgressRepository lessonProgressRepository;
    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;

    public LessonProgressService(LessonProgressRepository lessonProgressRepository,
                                 UserRepository userRepository,
                                 LessonRepository lessonRepository) {
        this.lessonProgressRepository = lessonProgressRepository;
        this.userRepository = userRepository;
        this.lessonRepository = lessonRepository;
    }

    // Start Progress
    public LessonProgressResponse startProgress(LessonProgressRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Lesson lesson = lessonRepository.findById(request.getLessonId())
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found"));

        if (lessonProgressRepository.existsByUserIdAndLessonId(
                request.getUserId(),
                request.getLessonId())) {

            throw new DuplicateResourceException("Progress already exists");
        }

        LessonProgress progress = new LessonProgress();
        progress.setUser(user);
        progress.setLesson(lesson);

        LessonProgress saved = lessonProgressRepository.save(progress);

        return new LessonProgressResponse(
                saved.getId(),
                user.getId(),
                user.getFullName(),
                lesson.getId(),
                lesson.getTitle(),
                saved.isCompleted(),
                saved.getCompletedAt()
        );
    }

    // Get Progress by Course
    public List<LessonProgressResponse> getProgressByCourse(Long userId,
                                                            Long courseId) {

        return lessonProgressRepository
                .findByLessonCourseIdAndUserId(courseId, userId)
                .stream()
                .map(progress -> new LessonProgressResponse(
                        progress.getId(),
                        progress.getUser().getId(),
                        progress.getUser().getFullName(),
                        progress.getLesson().getId(),
                        progress.getLesson().getTitle(),
                        progress.isCompleted(),
                        progress.getCompletedAt()
                ))
                .collect(Collectors.toList());
    }
    public LessonProgressResponse completeLesson(Long progressId) {

        LessonProgress progress = lessonProgressRepository.findById(progressId)
                .orElseThrow(() -> new ResourceNotFoundException("Progress not found"));

        progress.setCompleted(true);
        progress.setCompletedAt(java.time.LocalDateTime.now());

        LessonProgress saved = lessonProgressRepository.save(progress);

        return new LessonProgressResponse(
                saved.getId(),
                saved.getUser().getId(),
                saved.getUser().getFullName(),
                saved.getLesson().getId(),
                saved.getLesson().getTitle(),
                saved.isCompleted(),
                saved.getCompletedAt()
        );
    }
    public CourseProgressResponse getCourseProgress(Long userId, Long courseId) {

        Course course = lessonRepository.findById(
                        lessonRepository.findByCourseIdOrderByLessonOrderAsc(courseId)
                                .stream()
                                .findFirst()
                                .orElseThrow(() -> new ResourceNotFoundException("Course has no lessons"))
                                .getId()
                ).orElseThrow(() -> new ResourceNotFoundException("Lesson not found"))
                .getCourse();

        long totalLessons = lessonRepository.countByCourseId(courseId);

        long completedLessons = lessonProgressRepository
                .countByUserIdAndLessonCourseIdAndCompletedTrue(userId, courseId);

        double percentage = 0;

        if (totalLessons > 0) {
            percentage = (completedLessons * 100.0) / totalLessons;
        }

        return new CourseProgressResponse(
                course.getId(),
                course.getTitle(),
                totalLessons,
                completedLessons,
                percentage
        );
    }
}