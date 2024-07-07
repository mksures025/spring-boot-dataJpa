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
public class Department {
    @Id
    private String DeptName;

   @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    private List<Student> student;
}
