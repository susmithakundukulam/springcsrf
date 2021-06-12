package com.ocp.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocp.demo.dao.EmployeeDao;
import com.ocp.demo.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	public List<Employee> getAllEmployee(){
				
		return employeeDao.getAllEmployee();
		
	}

	public Employee getEmployeeById(int id){
		
		return employeeDao.getEmployeeById(id);
		
	}
}
