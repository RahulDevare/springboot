package com.practice.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.practice.demo.exception.EmployeeAlreadyExistException;
import com.practice.demo.exception.EmployeeNotFoundException;
import com.practice.demo.pojo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private Map<Integer,Employee> empMap = new HashMap<>();
	public EmployeeServiceImpl() {
		empMap.put(123, new Employee(123,"Rahul",20000));
		empMap.put(124, new Employee(124,"Shweta",30000));
		empMap.put(125, new Employee(125,"Vijay",25000));
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = new ArrayList<Employee>(empMap.values());
		return empList;
	}

	@Override
	public Employee getEmployee(int employeeId) {
		if(empMap.containsKey(employeeId)) {
			return empMap.get(employeeId);
		}else {
			throw new RuntimeException("No Employee Exists");
			//throw new EmployeeNotFoundException("EMP-404","Employee not found with Id: "+employeeId);
		}
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if(empMap.containsKey(employee.getId())) {
			throw new EmployeeAlreadyExistException("EMP-403","Employee already exist with Id: "+employee.getId());
		}else {
			empMap.put(employee.getId(), employee);
			return true;
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		if(empMap.containsKey(employee.getId())) throw new EmployeeNotFoundException("EMP-404","Employee not found with Id: "+employee.getId());
		empMap.remove(employee.getId());
		empMap.put(employee.getId(), employee);
		return employee;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		if(empMap.containsKey(employeeId)) {
			empMap.remove(employeeId);
			return true;
		}else {
			throw new EmployeeNotFoundException("EMP-404","Employee not found with Id: "+employeeId);
		}
	}
}
