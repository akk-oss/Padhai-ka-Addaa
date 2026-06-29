package com.padhai.backend.controller;
import java.util.List;
import com.padhai.backend.dto.EnrollmentRequest;
import com.padhai.backend.dto.EnrollmentResponse;
import com.padhai.backend.service.EnrollmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public EnrollmentResponse enrollStudent(@Valid @RequestBody EnrollmentRequest request) {
        return enrollmentService.enrollStudent(request);
    }
    @GetMapping("/user/{userId}")
    public List<EnrollmentResponse> getEnrollmentsByUser(@PathVariable Long userId) {
        return enrollmentService.getEnrollmentsByUser(userId);
    }
    @GetMapping("/course/{courseId}")
    public List<EnrollmentResponse> getEnrollmentsByCourse(@PathVariable Long courseId) {
        return enrollmentService.getEnrollmentsByCourse(courseId);
    }
    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable Long id) {
        return enrollmentService.deleteEnrollment(id);
    }
}