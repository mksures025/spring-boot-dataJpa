package com.te.cms.repository;

import com.te.cms.entity.Address;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {


	List<Address> findByCity(String string);
	
	
	
	
}
