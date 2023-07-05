package com.springtest.springtest.workstation;

import com.springtest.springtest.student.Student;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Workstation {
    @Id
    @Column
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "workstation_sequence"
    )
    @SequenceGenerator(
            name = "workstation_sequence",
            sequenceName = "workstation_sequence",
            allocationSize = 1
    )
    private Integer id;
    @Column
    private String ram;
    @Column
    private String storage;
    @Column
    private String operatingSystem;
//    For bidirectional relationship
//    @OneToOne(mappedBy = "workstation")
//    private Student student;
}
