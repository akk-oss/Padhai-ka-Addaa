package com.padhai.backend.controller;

import com.padhai.backend.dto.FileUploadResponse;
import com.padhai.backend.service.FileStorageService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
public class FileController {

    private final FileStorageService fileStorageService;

    public FileController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FileUploadResponse uploadFile(
            @RequestParam("file") MultipartFile file) throws Exception {

        return fileStorageService.uploadFile(file);
    }
}