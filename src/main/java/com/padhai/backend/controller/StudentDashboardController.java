package com.padhai.backend.controller;

import com.padhai.backend.dto.StudentDashboardResponse;
import com.padhai.backend.service.StudentDashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class StudentDashboardController {

    private final StudentDashboardService studentDashboardService;

    public StudentDashboardController(StudentDashboardService studentDashboardService) {
        this.studentDashboardService = studentDashboardService;
    }

    @GetMapping("/student/{userId}")
    public StudentDashboardResponse getDashboard(@PathVariable Long userId) {

        return studentDashboardService.getDashboard(userId);
    }
}