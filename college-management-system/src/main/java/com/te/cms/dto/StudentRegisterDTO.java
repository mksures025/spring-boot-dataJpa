package com.te.cms.dto;

import lombok.*;

import java.util.List;

import com.te.cms.entity.Department;


@Builder
@Setter
@Getter
public class StudentRegisterDTO{

       String studentId;
       String studentAge;
       String studentName;
       List<AddressDTO> address;
       DepartmentDTO department;


}
