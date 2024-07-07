package com.te.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
