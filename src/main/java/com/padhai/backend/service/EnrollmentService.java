package com.padhai.backend.service;
import java.util.List;
import java.util.stream.Collectors;
import com.padhai.backend.dto.EnrollmentRequest;
import com.padhai.backend.dto.EnrollmentResponse;
import com.padhai.backend.entity.Course;
import com.padhai.backend.entity.Enrollment;
import com.padhai.backend.entity.User;
import com.padhai.backend.exception.DuplicateResourceException;
import com.padhai.backend.exception.ResourceNotFoundException;
import com.padhai.backend.repository.CourseRepository;
import com.padhai.backend.repository.EnrollmentRepository;
import com.padhai.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository,
                             UserRepository userRepository,
                             CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    public EnrollmentResponse enrollStudent(EnrollmentRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));

        if (enrollmentRepository.existsByUserIdAndCourseId(
                request.getUserId(),
                request.getCourseId())) {

            throw new DuplicateResourceException("Student already enrolled in this course");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);

        return new EnrollmentResponse(
                savedEnrollment.getId(),
                user.getId(),
                user.getFullName(),
                course.getId(),
                course.getTitle(),
                savedEnrollment.getEnrolledAt()
        );
    }
    public List<EnrollmentResponse> getEnrollmentsByUser(Long userId) {

        return enrollmentRepository.findByUserId(userId)
                .stream()
                .map(enrollment -> new EnrollmentResponse(
                        enrollment.getId(),
                        enrollment.getUser().getId(),
                        enrollment.getUser().getFullName(),
                        enrollment.getCourse().getId(),
                        enrollment.getCourse().getTitle(),
                        enrollment.getEnrolledAt()
                ))
                .collect(Collectors.toList());
    }
    public List<EnrollmentResponse> getEnrollmentsByCourse(Long courseId) {

        return enrollmentRepository.findByCourseId(courseId)
                .stream()
                .map(enrollment -> new EnrollmentResponse(
                        enrollment.getId(),
                        enrollment.getUser().getId(),
                        enrollment.getUser().getFullName(),
                        enrollment.getCourse().getId(),
                        enrollment.getCourse().getTitle(),
                        enrollment.getEnrolledAt()
                ))
                .collect(Collectors.toList());
    }
    public String deleteEnrollment(Long id) {

        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));

        enrollmentRepository.delete(enrollment);

        return "Enrollment deleted successfully";
    }
}