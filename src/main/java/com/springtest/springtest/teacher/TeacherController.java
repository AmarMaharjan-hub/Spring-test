package com.springtest.springtest.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/initializeTeachers")
    public void initializeTeachers(@RequestBody List<Teacher> teachers){
        teacherService.initializeTeachers(teachers);
    }
    @PostMapping("/setTeacher")
    public void setTeacher(@RequestBody Teacher teacher){
        teacherService.setTeacher(teacher);
    }
    @GetMapping
    public List<String> getTeachers(){
        List<Teacher> teachers = teacherService.getAllTeachers();
        return teachers.stream().map(Teacher::getName).collect(Collectors.toList());
    }

}
