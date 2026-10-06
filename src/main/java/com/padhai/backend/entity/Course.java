package com.padhai.backend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 3000)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    private String thumbnailUrl;

    // Home Page course fields
    @Column(length = 255)
    private String subtitle;

    @Column(length = 1000)
    private String subjects;

    @Column(name = "old_price")
    private BigDecimal oldPrice;

    @Column(length = 100)
    private String tag;

    @Column(length = 50)
    private String icon;

    @Column(length = 100)
    private String gradient;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Course() {
    }

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
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

    public Category getCategory() {
        return category;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
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

    public void setCategory(Category category) {
        this.category = category;
    }
}