package com.te.ems.service;

import com.te.ems.dto.EmployeeBasicDTO;
import com.te.ems.dto.EmployeeRegDTO;

import java.util.List;

public interface EmployeeService {

	EmployeeBasicDTO getEmployee(Integer employeeId);

	List<EmployeeBasicDTO> getAllEmployees();

	Integer saveEmployee(EmployeeRegDTO employeeRegDTO);

    boolean updateEmployee(Integer employeeId, EmployeeRegDTO employeeRegDTO);

    boolean deleteEmployee(Integer employeeId);
}
