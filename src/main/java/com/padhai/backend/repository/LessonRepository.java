package com.padhai.backend.repository;

import com.padhai.backend.entity.Lesson;
import com.padhai.backend.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByCourse(Course course);

    List<Lesson> findByCourseIdOrderByLessonOrderAsc(Long courseId);

    boolean existsByCourseIdAndLessonOrder(Long courseId, Integer lessonOrder);

    List<Lesson> findByTitleContainingIgnoreCase(String keyword);
}