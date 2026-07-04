package com.padhai.backend.dto;

public class FileUploadResponse {

    private String fileName;
    private String fileUrl;

    public FileUploadResponse() {
    }

    public FileUploadResponse(String fileName, String fileUrl) {
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}