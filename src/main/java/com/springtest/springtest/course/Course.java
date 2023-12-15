package com.springtest.springtest.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springtest.springtest.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonIgnore
    @ManyToMany(mappedBy = "studentCourse")
    private List<Student> student;
}
