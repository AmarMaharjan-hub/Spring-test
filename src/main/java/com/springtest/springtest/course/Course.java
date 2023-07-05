package com.springtest.springtest.course;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
public class Course {
    @Id
    @Column
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "course_sequence"
    )
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    private Long id;
    @Column
    private String name;
    @Column
    private Integer creditHours;
}
