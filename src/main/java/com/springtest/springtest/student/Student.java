package com.springtest.springtest.student;

import com.springtest.springtest.course.Course;
import com.springtest.springtest.workstation.Workstation;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Data
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "student_sequence"
    )
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String contactNo;
    @Column
    private Integer grade;
    @Column
    private Integer age;
    @OneToOne(cascade = CascadeType.ALL)
    //default name of the fk column is also workstation_id
    @JoinColumn(name = "workstation_id")
    private Workstation workstation;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private List<Course> course;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", grade=" + grade +
                ", age=" + age +
                '}';
    }
}
