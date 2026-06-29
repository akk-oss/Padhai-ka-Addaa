package com.padhai.backend.service;
import com.padhai.backend.exception.ResourceNotFoundException;
import com.padhai.backend.dto.CourseRequest;
import com.padhai.backend.dto.CourseResponse;
import com.padhai.backend.entity.Category;
import com.padhai.backend.entity.Course;
import com.padhai.backend.repository.CategoryRepository;
import com.padhai.backend.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;

    public CourseService(CourseRepository courseRepository,
                         CategoryRepository categoryRepository) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
    }

    public CourseResponse createCourse(CourseRequest request) {

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        Course course = new Course();
        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setPrice(request.getPrice());
        course.setThumbnailUrl(request.getThumbnailUrl());
        course.setCategory(category);

        Course savedCourse = courseRepository.save(course);

        return new CourseResponse(
                savedCourse.getId(),
                savedCourse.getTitle(),
                savedCourse.getDescription(),
                savedCourse.getPrice(),
                savedCourse.getThumbnailUrl(),
                category.getId(),
                category.getName()
        );
    }

    public List<CourseResponse> getAllCourses() {

        return courseRepository.findAll()
                .stream()
                .map(course -> new CourseResponse(
                        course.getId(),
                        course.getTitle(),
                        course.getDescription(),
                        course.getPrice(),
                        course.getThumbnailUrl(),
                        course.getCategory().getId(),
                        course.getCategory().getName()
                ))
                .collect(Collectors.toList());
    }
    public CourseResponse getCourseById(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        return new CourseResponse(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getPrice(),
                course.getThumbnailUrl(),
                course.getCategory().getId(),
                course.getCategory().getName()
        );
    }

    public CourseResponse updateCourse(Long id, CourseRequest request) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setPrice(request.getPrice());
        course.setThumbnailUrl(request.getThumbnailUrl());
        course.setCategory(category);

        Course updatedCourse = courseRepository.save(course);

        return new CourseResponse(
                updatedCourse.getId(),
                updatedCourse.getTitle(),
                updatedCourse.getDescription(),
                updatedCourse.getPrice(),
                updatedCourse.getThumbnailUrl(),
                category.getId(),
                category.getName()
        );
    }
    public String deleteCourse(Long id) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        courseRepository.delete(course);

        return "Course deleted successfully";
    }
}