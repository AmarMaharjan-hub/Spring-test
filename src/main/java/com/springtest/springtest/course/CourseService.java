package com.springtest.springtest.course;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }
    public void addCourse(Course course) {
        courseRepository.save(course);
        courseRepository.flush();
    }
    public void updateCourseById(Long id, String name, int creditHour) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Course id doesn't exists"
                        )
                );
        course.setName(name);
        course.setCreditHours(creditHour);
        courseRepository.save(course);
        courseRepository.flush();
    }

    public void deleteCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalStateException(
                                "Course id doesn't exists"
                        )
                );
        courseRepository.deleteById(id);
        courseRepository.flush();
    }
//    @Transactional
    public Course courseById(Long courseId) {
        if(courseRepository.existsById(courseId)){
            return courseRepository.findById(courseId).orElseThrow(
                    () -> (
                            new IllegalStateException(
                                    "Student id doesn't exists"
                            )
                    )
            );
        }else{
            throw new IllegalStateException("Student id doesn't exists");
        }
    }
}
