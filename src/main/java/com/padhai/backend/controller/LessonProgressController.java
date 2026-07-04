package com.padhai.backend.controller;
import com.padhai.backend.dto.CourseProgressResponse;
import com.padhai.backend.dto.LessonProgressRequest;
import com.padhai.backend.dto.LessonProgressResponse;
import com.padhai.backend.service.LessonProgressService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
public class LessonProgressController {

    private final LessonProgressService lessonProgressService;

    public LessonProgressController(LessonProgressService lessonProgressService) {
        this.lessonProgressService = lessonProgressService;
    }

    // Start Progress
    @PreAuthorize("hasAnyRole('ADMIN','STUDENT')")
    @PostMapping
    public LessonProgressResponse startProgress(
            @Valid @RequestBody LessonProgressRequest request) {

        return lessonProgressService.startProgress(request);
    }

    // Get Progress by User & Course
    @PreAuthorize("hasAnyRole('ADMIN','STUDENT')")
    @GetMapping("/user/{userId}/course/{courseId}")
    public List<LessonProgressResponse> getProgressByCourse(
            @PathVariable Long userId,
            @PathVariable Long courseId) {

        return lessonProgressService.getProgressByCourse(userId, courseId);
    }
    @PutMapping("/{id}/complete")
    public LessonProgressResponse completeLesson(@PathVariable Long id) {

        return lessonProgressService.completeLesson(id);
    }
    @GetMapping("/user/{userId}/course/{courseId}/percentage")
    public CourseProgressResponse getCourseProgress(
            @PathVariable Long userId,
            @PathVariable Long courseId) {

        return lessonProgressService.getCourseProgress(userId, courseId);
    }
}