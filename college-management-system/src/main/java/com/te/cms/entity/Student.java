package com.te.cms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name="student_tbl")
public class Student {

    @Id
    @Column(name="stu_Id")
    private String studentId;
    @Column(name="stu_name")
    private String studentName;
    @Column(name="stu_age")
    private String studentAge;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="dep_fk")
    private Department department;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Address> address;

}
