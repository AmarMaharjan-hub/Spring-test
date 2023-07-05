package com.springtest.springtest.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    private final StudentDTO studentRequestDTO;
    @Autowired
    public StudentMapper(StudentDTO studentDTO) {
        this.studentRequestDTO = studentDTO;
    }

    public static StudentDTO toDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setName(student.getName());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setContactNo(student.getContactNo());
        studentDTO.setAge(student.getAge());
        return studentDTO;
    }

    public static Student toCourse(StudentRequestDTO studentRequestDTO) {
        Student student = new Student();
        student.setId(studentRequestDTO.getId());
        student.setName(studentRequestDTO.getName());
        student.setAddress(studentRequestDTO.getAddress());
        return student;
    }
}
