package com.pharmacy.springboot.controller;

import com.pharmacy.springboot.exception.ResourceNotFoundException;
import com.pharmacy.springboot.model.Employee;
import com.pharmacy.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    //build create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //build get employee REST API
    //nikhil choudhary 50291
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employeee not exist with id:" + id));
        return  ResponseEntity.ok(employee);
    }

    //build update employee REST API
    //nikhil choudhary 50291
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" +id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailID(employeeDetails.getEmailID());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    //build delete employee REST API
    //nikhil choudhary 50291
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employeee not exist with id" +id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
