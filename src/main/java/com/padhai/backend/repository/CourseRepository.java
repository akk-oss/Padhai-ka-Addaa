package com.padhai.backend.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.padhai.backend.entity.Category;
import com.padhai.backend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Page<Course> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);
    List<Course> findByCategory(Category category);

    List<Course> findByTitleContainingIgnoreCase(String keyword);

}