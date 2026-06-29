package com.padhai.backend.service;

import com.padhai.backend.dto.LessonRequest;
import com.padhai.backend.entity.Course;
import com.padhai.backend.entity.Lesson;
import com.padhai.backend.repository.CourseRepository;
import com.padhai.backend.repository.LessonRepository;
import org.springframework.stereotype.Service;
import com.padhai.backend.dto.LessonResponse;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    public LessonService(LessonRepository lessonRepository,
                         CourseRepository courseRepository) {
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;
    }

    // ✅ Create Lesson

    public LessonResponse createLesson(LessonRequest request) {

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        if (lessonRepository.existsByCourseIdAndLessonOrder(
                request.getCourseId(),
                request.getLessonOrder())) {

            throw new RuntimeException("Lesson order already exists");
        }

        Lesson lesson = new Lesson();
        lesson.setTitle(request.getTitle());
        lesson.setDescription(request.getDescription());
        lesson.setVideoUrl(request.getVideoUrl());
        lesson.setDuration(request.getDuration());
        lesson.setLessonOrder(request.getLessonOrder());
        lesson.setCourse(course);

        Lesson savedLesson = lessonRepository.save(lesson);

        return new LessonResponse(
                savedLesson.getId(),
                savedLesson.getTitle(),
                savedLesson.getDescription(),
                savedLesson.getVideoUrl(),
                savedLesson.getDuration(),
                savedLesson.getLessonOrder(),
                course.getId(),
                course.getTitle()
        );
    }
    // ✅ Get Lessons by Course (sorted)
    public List<LessonResponse> getLessonsByCourse(Long courseId) {

        courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return lessonRepository.findByCourseIdOrderByLessonOrderAsc(courseId)
                .stream()
                .map(lesson -> new LessonResponse(
                        lesson.getId(),
                        lesson.getTitle(),
                        lesson.getDescription(),
                        lesson.getVideoUrl(),
                        lesson.getDuration(),
                        lesson.getLessonOrder(),
                        lesson.getCourse().getId(),
                        lesson.getCourse().getTitle()
                ))
                .collect(Collectors.toList());
    }
    public LessonResponse getLessonById(Long id) {

        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        return new LessonResponse(
                lesson.getId(),
                lesson.getTitle(),
                lesson.getDescription(),
                lesson.getVideoUrl(),
                lesson.getDuration(),
                lesson.getLessonOrder(),
                lesson.getCourse().getId(),
                lesson.getCourse().getTitle()
        );
    }
    public LessonResponse updateLesson(Long id, LessonRequest request) {

        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Duplicate lesson order check
        if (!lesson.getLessonOrder().equals(request.getLessonOrder())
                && lessonRepository.existsByCourseIdAndLessonOrder(
                request.getCourseId(),
                request.getLessonOrder())) {

            throw new RuntimeException("Lesson order already exists");
        }

        lesson.setTitle(request.getTitle());
        lesson.setDescription(request.getDescription());
        lesson.setVideoUrl(request.getVideoUrl());
        lesson.setDuration(request.getDuration());
        lesson.setLessonOrder(request.getLessonOrder());
        lesson.setCourse(course);

        Lesson updatedLesson = lessonRepository.save(lesson);

        return new LessonResponse(
                updatedLesson.getId(),
                updatedLesson.getTitle(),
                updatedLesson.getDescription(),
                updatedLesson.getVideoUrl(),
                updatedLesson.getDuration(),
                updatedLesson.getLessonOrder(),
                updatedLesson.getCourse().getId(),
                updatedLesson.getCourse().getTitle()
        );
    }
    public String deleteLesson(Long id) {

        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        lessonRepository.delete(lesson);

        return "Lesson deleted successfully";
    }
}