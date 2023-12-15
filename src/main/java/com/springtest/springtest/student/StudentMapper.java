package com.springtest.springtest.student;

import com.springtest.springtest.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    private static StudentDTO studentDTO;
    private static StudentService studentService;
    private static CourseService courseService;

    @Autowired
    public StudentMapper(StudentDTO studentDTO, StudentService studentService) {
        this.studentDTO = studentDTO;
        this.studentService = studentService;
    }

    public static StudentDTO toDTO(Student student) {
        studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setContactNo(student.getContactNo());
        studentDTO.setAge(student.getAge());
        return studentDTO;
    }

    public static Student toStudent(StudentUpdateRequestDTO studentRequestDTO) {
        Student student = studentService.studentById(studentRequestDTO.getId());
        student.setName(studentRequestDTO.getName());
        student.setAddress(studentRequestDTO.getAddress());
        return student;
    }

    public static Student courseToStudent(Long studentId){
        if(studentService.studentById(studentId) == null){
            return null;
        }
//        for(Long i : courseId){
//            if(courseService.courseById(i) == null){
//                return null;
//            }
//        }
        return studentService.studentById(studentId);
    }
}
