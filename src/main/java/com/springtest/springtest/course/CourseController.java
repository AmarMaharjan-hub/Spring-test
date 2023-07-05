package com.springtest.springtest.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/course")
public class CourseController {
    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    public List<Course> getCourse(){
        return courseService.getAllCourse();
    }
    @PostMapping
    public void addCourse(
            @RequestBody Course course
    ){
        courseService.addCourse(course);
    }
    @PutMapping
    public void updateCourseById(
            @RequestParam Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int creditHour
    ){
        courseService.updateCourseById(id, name, creditHour);
    }
    @DeleteMapping
    public void deleteCourseById(@RequestParam Long id){
        courseService.deleteCourseById(id);
    }
}
