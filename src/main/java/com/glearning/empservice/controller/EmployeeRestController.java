package com.glearning.empservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.empservice.model.Employee;
import com.glearning.empservice.service.EmployeeService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

	private EmployeeService empService;

	public EmployeeRestController(EmployeeService empService) {
		this.empService = empService;
	}

	// fetching all the employees
	@GetMapping
	@ApiResponse(description = "fetches all the employees", responseCode = "200", content = @Content(mediaType = "application/json"))

	public List<Employee> fetchAll() {
		return this.empService.findAll();
	}

	// fetch employee by id
	@GetMapping("/{id}")
	public Employee findByEmpId(@PathVariable("id") long id) {
		return this.empService.fetchEmployeeById(id);
	}

	// fetch employee by id
	@GetMapping("/search")
	public Employee findByNameAndEmail(
			@RequestParam(name="name",required = true ) String name,
			@RequestParam(name="email",required = true ) String email
			) {
		return this.empService.findByNameAndEmail(name, email);
	}

	// delete employee by id
	@DeleteMapping("/{id}")
	public void deleteByEmpId(@PathVariable("id") long id) {
		this.empService.deleteEmployeeById(id);
	}

	// save the employee
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee emp) {
		return this.empService.saveEmployee(emp);
	}

}
