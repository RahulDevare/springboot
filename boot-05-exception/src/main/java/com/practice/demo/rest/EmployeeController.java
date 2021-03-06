package com.practice.demo.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.demo.pojo.Employee;
import com.practice.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ResponseEntity<Object> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Object> getEmployee(@PathVariable("id") int empId) {
		Employee employee = employeeService.getEmployee(empId);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee emp) {
		boolean isEmpAdded = employeeService.addEmployee(emp);
		return new ResponseEntity<>(isEmpAdded, HttpStatus.CREATED);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee emp) {
		Employee employee = employeeService.updateEmployee(emp);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int empId) {
		boolean idEmpDeleted = employeeService.deleteEmployee(empId);
		return new ResponseEntity<>(idEmpDeleted, HttpStatus.OK);
	}
}
