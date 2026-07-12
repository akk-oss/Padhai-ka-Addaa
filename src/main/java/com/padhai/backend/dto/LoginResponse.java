package com.padhai.backend.dto;

public class LoginResponse {

    private String token;
    private String role;
    private String fullName;
    private String email;
    private Long id;

    public LoginResponse() {
    }

    public LoginResponse(String token,
                         String role,
                         String fullName,
                         String email,
                         Long id) {

        this.token = token;
        this.role = role;
        this.fullName = fullName;
        this.email = email;
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}