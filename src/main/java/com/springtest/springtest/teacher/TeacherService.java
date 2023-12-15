package com.springtest.springtest.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void add(Teacher teacher) {
        teacherRepository.save(teacher);
        teacherRepository.flush();
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public void initializeTeachers(List<Teacher> teachers) {
//        teacherRepository.saveAll(teachers);
        teacherRepository.saveAll(initializeMultipleId(teachers));
        teacherRepository.flush();
    }

    public List<Teacher> initializeMultipleId(List<Teacher> teachers){
        while(teachers.listIterator().hasNext()){
            teachers.listIterator().next().setId(UUID.randomUUID());
        }
        return teachers;
    }

    public void setTeacher(Teacher teacher) {
        teacher.setId(UUID.randomUUID());
        teacherRepository.save(teacher);
        teacherRepository.flush();
    }
}
