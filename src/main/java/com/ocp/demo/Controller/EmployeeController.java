package com.ocp.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ocp.demo.model.Employee;


public interface EmployeeController {
	
	@RequestMapping("/")
	public String sayHello();
	
	@GetMapping("/getAllEmployees")
	public List<Employee> gwtAllEmployee();

	@PostMapping("/getEmployeesById")
	public Employee getEmployeeById(@RequestParam("id") int id);
}
