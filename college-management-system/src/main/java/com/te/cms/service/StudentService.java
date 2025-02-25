package com.te.cms.service;

import java.util.List;

import com.te.cms.dto.AddressDTO;
import com.te.cms.dto.StudentRegisterDTO;

public interface StudentService {
    String saveData(StudentRegisterDTO studentRegisterDTO);

    String updateStudentName(StudentRegisterDTO studentRegisterDTO);

	StudentRegisterDTO fetchById(String studentid);

	List<StudentRegisterDTO> fetchStudent();

	List<StudentRegisterDTO> fetchByName();

	List<AddressDTO> fetchByAddress();

	String updateStudenrt(StudentRegisterDTO studentRegisterDTO);
	
	
}
