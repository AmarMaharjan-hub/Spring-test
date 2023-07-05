package com.springtest.springtest.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
        studentRepository.flush();
    }
    @Transactional
    public void updateStudent(Student student) {
//        if(studentRepository.existsById(student.getId())){
//            studentRepository.save(student);
//        }
        Student student1 = studentRepository.findById(student.getId())
                .orElseThrow(() -> (
                        new IllegalStateException(
                                "Student id doesn't exists"
                        )
                        ));
        student1.setName(student.getName());
        student1.setAddress(student.getAddress());
    }

    public void deleteStudent(Long studentId) {
        if(studentRepository.existsById(studentId)){
            studentRepository.deleteById(studentId);
        }
    }
}
