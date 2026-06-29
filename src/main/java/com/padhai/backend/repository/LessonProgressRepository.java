package com.padhai.backend.repository;

import com.padhai.backend.entity.LessonProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonProgressRepository extends JpaRepository<LessonProgress, Long> {

    List<LessonProgress> findByUserId(Long userId);

    List<LessonProgress> findByLessonCourseIdAndUserId(Long courseId, Long userId);

    Optional<LessonProgress> findByUserIdAndLessonId(Long userId, Long lessonId);

    boolean existsByUserIdAndLessonId(Long userId, Long lessonId);
    long countByUserIdAndLessonCourseIdAndCompletedTrue(Long userId, Long courseId);
}