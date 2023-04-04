package com.glearning.empservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.empservice.model.Employee;
import com.glearning.empservice.repository.EmployeeCrudRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeCrudRepository empRepository;
	
	public EmployeeServiceImpl(EmployeeCrudRepository empRepository) {
		this.empRepository = empRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		//perform the validation
		return this.empRepository.save(employee);
	}

	@Override
	public List<Employee> findAll() {
		return this.empRepository.findAll();
	}

	@Override
	public Employee fetchEmployeeById(long empId) {
		return this.empRepository.findById(empId).orElseThrow();
	}

	@Override
	public void deleteEmployeeById(long empId) {
		this.empRepository.deleteById(empId);
	}

	@Override
	public Employee findByNameAndEmail(String name, String email) {
		return this.empRepository.findByNameAndEmail(name, email).orElseThrow();
	}
}