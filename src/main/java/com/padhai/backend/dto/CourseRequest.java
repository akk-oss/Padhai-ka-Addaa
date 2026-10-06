package com.padhai.backend.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class CourseRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.0", inclusive = true)
    private BigDecimal price;

    private String thumbnailUrl;

    // Home Page fields
    private String subtitle;

    private String subjects;

    private BigDecimal oldPrice;

    private String tag;

    private String icon;

    private String gradient;

    @NotNull(message = "Category Id is required")
    private Long categoryId;


    // ================= CONSTRUCTOR =================

    public CourseRequest() {
    }


    // ================= GETTERS =================

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getSubjects() {
        return subjects;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public String getTag() {
        return tag;
    }

    public String getIcon() {
        return icon;
    }

    public String getGradient() {
        return gradient;
    }

    public Long getCategoryId() {
        return categoryId;
    }


    // ================= SETTERS =================

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setGradient(String gradient) {
        this.gradient = gradient;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}