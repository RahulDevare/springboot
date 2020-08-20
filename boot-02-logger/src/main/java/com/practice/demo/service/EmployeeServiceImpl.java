package com.practice.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.practice.demo.exception.EmployeeAlreadyExistException;
import com.practice.demo.exception.EmployeeNotFoundException;
import com.practice.demo.pojo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
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
			logger.warn("getEmployee() - Employee not found with Id: "+employeeId);
			throw new EmployeeNotFoundException("EMP-404","Employee not found with Id: "+employeeId);
		}
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if(empMap.containsKey(employee.getId())) {
			logger.warn("addEmployee() - Employee already exist with Id: "+employee.getId());
			throw new EmployeeAlreadyExistException("EMP-403","Employee already exist with Id: "+employee.getId());
		}else {
			empMap.put(employee.getId(), employee);
			logger.info("Employee added successfully");
			return true;
		}
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		if(empMap.containsKey(employee.getId())) {
			logger.warn("updateEmployee() - Employee not found with Id: "+employee.getId());
			throw new EmployeeNotFoundException("EMP-404","Employee not found with Id: "+employee.getId());
		}
		empMap.remove(employee.getId());
		empMap.put(employee.getId(), employee);
		logger.info("Employee updated successfully");
		return employee;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		if(empMap.containsKey(employeeId)) {
			empMap.remove(employeeId);
			logger.info("Employee deleted successfully");
			return true;
		}else {
			logger.warn("deleteEmployee() - Employee not found with Id: "+employeeId);
			throw new EmployeeNotFoundException("EMP-404","Employee not found with Id: "+employeeId);
		}
	}
}
