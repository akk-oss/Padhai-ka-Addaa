package com.padhai.backend.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import com.padhai.backend.dto.LessonRequest;
import com.padhai.backend.dto.LessonResponse;
import com.padhai.backend.service.LessonService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    // 🎥 Create Lesson
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @PostMapping
    public LessonResponse createLesson(@Valid @RequestBody LessonRequest request) {
        return lessonService.createLesson(request);
    }

    // 📚 Get Lessons by Course (sorted)
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER','STUDENT')")
    @GetMapping("/course/{courseId}")
    public List<LessonResponse> getLessonsByCourse(@PathVariable Long courseId) {
        return lessonService.getLessonsByCourse(courseId);
    }@PreAuthorize("hasAnyRole('ADMIN','TEACHER','STUDENT')")
    @GetMapping("/{id}")
    public LessonResponse getLessonById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @PutMapping("/{id}")
    public LessonResponse updateLesson(@PathVariable Long id,
                                       @Valid @RequestBody LessonRequest request) {

        return lessonService.updateLesson(id, request);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteLesson(@PathVariable Long id) {
        return lessonService.deleteLesson(id);
    }
}