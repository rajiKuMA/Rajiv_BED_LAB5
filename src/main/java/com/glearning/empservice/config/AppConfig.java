package com.glearning.empservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.glearning.empservice.repository.EmployeeCrudRepository;

@Component
class DBHealth implements HealthIndicator {
	
	@Autowired
	private EmployeeCrudRepository empRepository;

	@Override
	public Health health() {
		 long empCount = this.empRepository.count();
		 if (empCount < 0 ) {
			 return Health.down().withDetail("DB Service " , "DB service is down").build();
		 }
		 return Health.up().withDetail("DB Service " , "DB service is up").build();
	}
}
