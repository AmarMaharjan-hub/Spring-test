package com.springtest.springtest.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
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

    @PutMapping
    public void updateStudent(
             @RequestBody StudentRequestDTO studentRequestDTO
    ){
        Student student = StudentMapper.toCourse(studentRequestDTO);
        studentService.updateStudent(student);
    }
//    @PutMapping(path = {"/id", "/studentName", "/studentAddress", "/studentContactNo", "/studentAge"})
//    public void updateAllAllowedStudentField(
//            @PathVariable("id") Long studentId,
//            @PathVariable("studentName") String name,
//            @PathVariable("studentAddress") String address,
//            @PathVariable("studentContactNo") String contact,
//            @PathVariable("studentAge") Integer age
//    ){
////        studentService.updateAllAllowedStudentField()
//
//    }
    @DeleteMapping(path = "/studentId/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
}
