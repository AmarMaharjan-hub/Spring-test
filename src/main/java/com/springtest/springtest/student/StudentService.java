package com.springtest.springtest.student;

import com.springtest.springtest.course.Course;
import com.springtest.springtest.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
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
        studentRepository.save(student);
    }
    @Transactional
    public Student studentById(Long id){
        if(studentRepository.existsById(id)){
            return studentRepository.findById(id).orElseThrow(
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

    public void deleteStudent(Long studentId) {
        if(studentRepository.existsById(studentId)){
            studentRepository.deleteById(studentId);
        }
    }

    public void courseToStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).get();
        Course course = courseRepository.findById(courseId).get();
        List<Course> courseList = student.getStudentCourse();
        courseList.add(course);
        student.setStudentCourse(courseList);
        studentRepository.save(student);
        studentRepository.flush();
    }

    public void multipleCourseToStudent(Student student, List<Course> courseIdList) {
//        while(courseIdList.listIterator().hasNext()){
//            Course course = courseIdList.listIterator().next();
//            student.setStudentCourse(course);
//        }
//        student.setStudentCourse(?);
        student.setStudentCourse(courseIdList);
        studentRepository.save(student);
        studentRepository.flush();
    }

    public void addMultipleStudents(List<Student> students) {
//        while(students.listIterator().hasNext()){
//            Student student = students.listIterator().next();
//            if(validator(student)){
//                studentRepository.save(student);
//                studentRepository.flush();
//            }
//        }
        studentRepository.saveAll(students);
        studentRepository.flush();
    }
    public boolean validator(Student student){
        if(student.getName().equals(null)){
            return false;
        }
        if(student.getAge().equals(null)){
            return false;
        }
        if(student.getGrade().equals(null)){
            return false;
        }
        if(student.getAge().equals(null)){
            return false;
        }
        if(student.getContactNo().equals(null)){
            return false;
        }
        return true;
    }
}
