package com.springtest.springtest.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
//    docker jdk
//    service ko naam host hunu paryo   
    @Id
//    @GeneratedValue(
//        generator = "teacher_sequence",
//        strategy = GenerationType.AUTO
//    )
//    @SequenceGenerator(
//        sequenceName = "teacher_sequence",
//        allocationSize = 1,
//        name = "teacher_sequence"
//    )
    @Column
    private UUID id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String contact;
}
