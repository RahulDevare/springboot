package com.practice.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") int empId) {
		return employeeService.getEmployee(empId);
	}
	
	@PostMapping("/employees")
	public boolean addEmployee(@RequestBody Employee emp) {
		return employeeService.addEmployee(emp);
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return employeeService.updateEmployee(emp);
	}
	
	@DeleteMapping("/employees/{id}")
	public boolean deleteEmployee(@PathVariable("id") int empId) {
		return employeeService.deleteEmployee(empId);
	}
}
