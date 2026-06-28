package com.padhai.backend.controller;

import com.padhai.backend.dto.CourseRequest;
import com.padhai.backend.dto.CourseResponse;
import com.padhai.backend.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public CourseResponse createCourse(@Valid @RequestBody CourseRequest request) {
        return courseService.createCourse(request);
    }

    @GetMapping
    public List<CourseResponse> getAllCourses() {
        return courseService.getAllCourses();
    }
    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }
    @PutMapping("/{id}")
    public CourseResponse updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequest request) {

        return courseService.updateCourse(id, request);
    }
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id) {
        return courseService.deleteCourse(id);
    }
}