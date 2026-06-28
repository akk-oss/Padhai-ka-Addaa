package com.padhai.backend.dto;

import java.math.BigDecimal;

public class CourseResponse {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private String thumbnailUrl;
    private Long categoryId;
    private String categoryName;

    public CourseResponse() {
    }

    public CourseResponse(Long id,
                          String title,
                          String description,
                          BigDecimal price,
                          String thumbnailUrl,
                          Long categoryId,
                          String categoryName) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.thumbnailUrl = thumbnailUrl;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Long getId() { return id; }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public BigDecimal getPrice() { return price; }

    public String getThumbnailUrl() { return thumbnailUrl; }

    public Long getCategoryId() { return categoryId; }

    public String getCategoryName() { return categoryName; }

    public void setId(Long id) { this.id = id; }

    public void setTitle(String title) { this.title = title; }

    public void setDescription(String description) { this.description = description; }

    public void setPrice(BigDecimal price) { this.price = price; }

    public void setThumbnailUrl(String thumbnailUrl) { this.thumbnailUrl = thumbnailUrl; }

    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}