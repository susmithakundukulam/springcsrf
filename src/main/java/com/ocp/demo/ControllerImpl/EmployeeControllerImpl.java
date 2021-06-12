package com.ocp.demo.ControllerImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.ocp.demo.Controller.EmployeeController;
import com.ocp.demo.model.Employee;
import com.ocp.demo.service.EmployeeService;

@RestController
public class EmployeeControllerImpl implements EmployeeController{
	
	@Autowired
	EmployeeService employeeService;

	@Override
	public String sayHello() {
		return "Hello World " + LocalDate.now();
	}

	@Override
	public List<Employee> gwtAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeService.getEmployeeById(id);
	}

}
