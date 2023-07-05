package com.springtest.springtest.student;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class StudentDTO {

    private String name;
    private String address;
    private String contactNo;
    private Integer age;
}
