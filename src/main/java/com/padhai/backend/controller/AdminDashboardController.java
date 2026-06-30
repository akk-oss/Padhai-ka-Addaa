package com.padhai.backend.controller;

import com.padhai.backend.dto.AdminDashboardResponse;
import com.padhai.backend.service.AdminDashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class AdminDashboardController {

    private final AdminDashboardService adminDashboardService;

    public AdminDashboardController(AdminDashboardService adminDashboardService) {
        this.adminDashboardService = adminDashboardService;
    }

    @GetMapping("/admin")
    public AdminDashboardResponse getDashboard() {
        return adminDashboardService.getDashboard();
    }
}