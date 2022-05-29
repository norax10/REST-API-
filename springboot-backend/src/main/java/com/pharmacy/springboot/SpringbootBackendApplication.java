package com.pharmacy.springboot;
//nikhil choudhary 50291

import com.pharmacy.springboot.model.Employee;
import com.pharmacy.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Nikhil");
		employee.setLastName("Choudhary");
		employee.setEmailID("nikhil@gmail.com");
		employeeRepository.save(employee);

		//nikhil choudhary 50291

		Employee employee1 = new Employee();
		employee1.setFirstName("vikas");
		employee1.setLastName("kalu");
		employee1.setEmailID("vikas@gmail.com");
		employeeRepository.save(employee1);
	}

}
