package com.practice.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.demo.pojo.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public Employee getEmployee(int employeeId);
	public boolean addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public boolean deleteEmployee(int employeeId);

}
