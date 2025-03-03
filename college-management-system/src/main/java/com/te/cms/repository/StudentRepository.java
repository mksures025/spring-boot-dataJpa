package com.te.cms.repository;

import com.te.cms.entity.Address;
import com.te.cms.entity.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

	List<Student> findByStudentName(String string);

	List<Student> findByAddressCity(String string);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Student s SET s.studentName = :studentName where s.studentId=:studentId ")
	void updateStudentName(@Param("studentName")String studentName, @Param("studentId")String studentId);
}
