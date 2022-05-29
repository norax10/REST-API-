package com.pharmacy.springboot.repository;

import com.pharmacy.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // all crud database methods
    // nikhil choudhary 50291
}
