package com.glearning.empservice.service;

import java.util.List;

import com.glearning.empservice.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> findAll();

	Employee fetchEmployeeById(long empId);

	void deleteEmployeeById(long empId);
	
	Employee findByNameAndEmail(String name, String email );

}
