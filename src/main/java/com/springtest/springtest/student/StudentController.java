package com.springtest.springtest.student;

import com.springtest.springtest.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;
    private final CourseService courseService;
    @Autowired
    public StudentController(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }
    @GetMapping
    public List<StudentDTO> getStudents(){
        List<Student> students = studentService.getStudents();
        System.out.println("returning get");
        return students
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }
    @PostMapping
    public String addStudent(@RequestBody Student student){
        System.out.println("Post received");
        studentService.addStudent(student);
        return "done";
    }

    @PostMapping("/initializeStudents")
    public void initializeStudents(@RequestBody List<Student> students){
        studentService.addMultipleStudents(students);
    }

    @PutMapping
    public void updateStudent(
             @RequestBody StudentUpdateRequestDTO studentUpdateRequestDTO
    ){
        studentService.updateStudent(StudentMapper.toStudent(studentUpdateRequestDTO));
    }
    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
    @PutMapping("/{studentId}/courseId/{courseId}")
    public void courseToStudent(
            @PathVariable("studentId") Long studentId,
            @PathVariable("courseId") Long courseId
    ){
        studentService.courseToStudent(studentId, courseId);
    }
//    @PutMapping("/multipleCourseToStudent")
//    public void multipleCourseToStudent(
//            @RequestBody StudentCourseDTO studentCourseDTO
//    ){
//        studentService.multipleCourseToStudent(
//            StudentMapper.courseToStudent(
//                studentCourseDTO.getStudentId()
//            ),
//            studentCourseDTO
//                    .getCourseIdList()
//                    .stream()
//                    .map(courseService::courseById)
//                    .collect(Collectors.toList())
//        );
//    }
    @PutMapping("/multipleCourseToStudent/{studentId}/")
    public void multipleCourseToStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody List<Long> courseIdList
    ){
        studentService.multipleCourseToStudent(
            studentService.studentById(studentId),
            courseIdList
                    .stream()
                    .map(courseService::courseById)
                    .collect(Collectors.toList())
        );
    }
}
