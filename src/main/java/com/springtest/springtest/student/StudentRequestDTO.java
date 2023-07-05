package com.springtest.springtest.student;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class StudentRequestDTO {
    private Long id;
    private String name;
    private String address;
}
