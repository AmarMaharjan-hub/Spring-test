package com.springtest.springtest.student;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class StudentCourseDTO {
    private Long studentId;
    private List<Long> courseIdList;


}
