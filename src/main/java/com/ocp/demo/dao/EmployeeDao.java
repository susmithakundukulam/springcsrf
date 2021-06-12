package com.ocp.demo.dao;

import java.util.List;

import com.ocp.demo.model.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeById(int id);
}
