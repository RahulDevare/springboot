package com.practice.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

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
		return empMap.get(employeeId);
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if(empMap.containsKey(employee.getId())) {
			return false;
		}else {
			empMap.put(employee.getId(), employee);
			return true;
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		empMap.put(employee.getId(), employee);
		return employee;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		if(empMap.containsKey(employeeId)) {
			empMap.remove(employeeId);
			return true;
		}else {
			return false;
		}
	}
}
