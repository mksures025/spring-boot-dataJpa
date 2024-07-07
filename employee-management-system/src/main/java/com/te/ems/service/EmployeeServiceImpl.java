package com.te.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

import com.te.ems.dto.AddressDTO;
import com.te.ems.dto.EmployeeRegDTO;
import com.te.ems.dto.TechnologyDTO;
import com.te.ems.entity.Address;
import com.te.ems.entity.BankAccount;
import com.te.ems.entity.Technology;
import com.te.ems.exception.EmployeeNotFoundException;
import com.te.ems.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

import com.te.ems.dto.EmployeeBasicDTO;
import com.te.ems.entity.Employee;
import com.te.ems.repository.EmployeeRepository;
import com.te.ems.util.EmployeeUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
 	private final EmployeeRepository employeeRepository;
	private final TechnologyRepository technologyRepository;

	@Override
	public EmployeeBasicDTO getEmployee(Integer employeeId) {	
		Employee employee =  employeeRepository.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee data not found on given employee Id"));

		return EmployeeUtils.convertEntityToDTO_(employee);
	}

	@Override
	public List<EmployeeBasicDTO> getAllEmployees() {
		return employeeRepository.findAll().stream().map( e -> {
			 return EmployeeUtils.convertEntityToDTO_(e);
		}).toList();
	}

	@Override
	public Integer saveEmployee(EmployeeRegDTO employeeRegDTO) {
		Employee employee = EmployeeUtils.convertDTOToEntity(employeeRegDTO);
		employeeRegDTO.technologies().stream().forEach(technologyDTO -> {
			Optional<Technology> optionalTechnology = technologyRepository.findById(technologyDTO.getTechnologyName());
			if(optionalTechnology.isPresent()){
				Technology t = optionalTechnology.get();
				employee.getTechnologies().add(t);
				t.getEmployees().add(employee);
			} else {
				Technology t = technologyRepository.save(Technology.builder()
						.technologyName(technologyDTO.getTechnologyName()).build());
				employee.getTechnologies().add(t);
				t.getEmployees().add(employee);
			}
			employeeRepository.save(employee);
		});

		return employee.getEmployeeId();
	}

	@Override
	public boolean updateEmployee(Integer employeeId, EmployeeRegDTO employeeRegDTO) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("employee is not found"));
		employee.setTechnologies(new ArrayList<>());

		employeeRegDTO.addresses().stream().map(e -> Address.builder()
				.addressCity(e.getAddressCity())
				.addressState(e.getAddressState())
				.addressType(e.getAddressType())
				.build());
		
		employee.setAddresses(new ArrayList<>());
		employeeRepository.save(employee);
		
        EmployeeUtils.updateFields(employee,employeeRegDTO);
        
		employeeRegDTO.technologies().stream().forEach(technologyDTO -> {
			Optional<Technology> optionalTechnology = technologyRepository.findById(technologyDTO.getTechnologyName());
			if(optionalTechnology.isPresent()){
				Technology t = optionalTechnology.get();
				employee.getTechnologies().add(t);
				t.getEmployees().add(employee);
			} else {
				Technology t = technologyRepository.save(Technology.builder().technologyName(technologyDTO.getTechnologyName()).build());
				employee.getTechnologies().add(t);
				t.getEmployees().add(employee);
			}
			employeeRepository.save(employee);
		});
		employeeRepository.save(employee);
		return true;
	}

	@Override
	public boolean deleteEmployee(Integer employeeId) {
		Employee employee1 = employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("employee not found exception"));
		employee1.setTechnologies(null);
		employeeRepository.save(employee1);

        if(employee1.getEmployeeId()!=null)
		{
			employeeRepository.deleteById(employeeId);
			return true;
		}
//		employeeRepository.findById(employeeId).ifPresent(employee -> {
//			employeeRepository.deleteById(employeeId);
//		});
		return false;
	}

}
