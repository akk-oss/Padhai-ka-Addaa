package com.padhai.backend.controller;
import com.padhai.backend.dto.ApiResponse;
import com.padhai.backend.dto.CourseRequest;
import com.padhai.backend.dto.CourseResponse;
import com.padhai.backend.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @PostMapping
    public ApiResponse<CourseResponse> createCourse(@RequestBody CourseRequest request) {

        CourseResponse response = courseService.createCourse(request);

        return new ApiResponse<>(
                true,
                "Course created successfully",
                response
        );
    }
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER','STUDENT')")
    @GetMapping
    public ApiResponse<List<CourseResponse>> getAllCourses() {

        return new ApiResponse<>(
                true,
                "Courses fetched successfully",
                courseService.getAllCourses()
        );
    }

    @GetMapping("/page")
    public Page<CourseResponse> getAllCoursesWithPagination(

            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(defaultValue = "") String keyword) {

        return courseService.getAllCourses(
                page,
                size,
                sortBy,
                direction,
                keyword
        );
    }
    @GetMapping("/{id}")
    public ApiResponse<CourseResponse> getCourseById(@PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Course fetched successfully",
                courseService.getCourseById(id)
        );
    }
    @PutMapping("/{id}")
    public ApiResponse<CourseResponse> updateCourse(
            @PathVariable Long id,
            @RequestBody CourseRequest request) {

        return new ApiResponse<>(
                true,
                "Course updated successfully",
                courseService.updateCourse(id, request)
        );
    }
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteCourse(@PathVariable Long id) {

        return new ApiResponse<>(
                true,
                "Course deleted successfully",
                courseService.deleteCourse(id)
        );
    }
}