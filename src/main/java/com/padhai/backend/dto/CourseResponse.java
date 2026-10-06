package com.padhai.backend.dto;

import java.math.BigDecimal;

public class CourseResponse {

    private Long id;

    private String title;

    private String description;

    private BigDecimal price;

    private String thumbnailUrl;

    // Home Page fields
    private String subtitle;

    private String subjects;

    private BigDecimal oldPrice;

    private String tag;

    private String icon;

    private String gradient;

    // Category information
    private Long categoryId;

    private String categoryName;


    // ================= CONSTRUCTOR =================

    public CourseResponse() {
    }


    public CourseResponse(
            Long id,
            String title,
            String description,
            BigDecimal price,
            String thumbnailUrl,
            String subtitle,
            String subjects,
            BigDecimal oldPrice,
            String tag,
            String icon,
            String gradient,
            Long categoryId,
            String categoryName) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.thumbnailUrl = thumbnailUrl;

        this.subtitle = subtitle;
        this.subjects = subjects;
        this.oldPrice = oldPrice;
        this.tag = tag;
        this.icon = icon;
        this.gradient = gradient;

        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }


    // ================= GETTERS =================

    public Long getId() {
        return id;
    }

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

    public String getCategoryName() {
        return categoryName;
    }


    // ================= SETTERS =================

    public void setId(Long id) {
        this.id = id;
    }

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

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}