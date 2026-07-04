package com.padhai.backend.controller;

import com.padhai.backend.dto.StudentDashboardResponse;
import com.padhai.backend.service.StudentDashboardService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class StudentDashboardController {

    private final StudentDashboardService studentDashboardService;

    public StudentDashboardController(StudentDashboardService studentDashboardService) {
        this.studentDashboardService = studentDashboardService;
    }
    @PreAuthorize("hasAnyRole('ADMIN','STUDENT')")
    @GetMapping("/student/{userId}")
    public StudentDashboardResponse getDashboard(@PathVariable Long userId) {

        return studentDashboardService.getDashboard(userId);
    }
}