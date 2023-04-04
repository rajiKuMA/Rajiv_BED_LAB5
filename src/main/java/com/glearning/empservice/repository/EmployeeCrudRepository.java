package com.glearning.empservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.empservice.model.Employee;

@Repository
public interface EmployeeCrudRepository extends JpaRepository<Employee, Long>{
	
	Optional<Employee> findByEmail(String email);
	Optional<Employee> findByNameAndEmail(String name, String email);

}
