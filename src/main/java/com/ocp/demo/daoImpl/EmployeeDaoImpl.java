package com.ocp.demo.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ocp.demo.dao.EmployeeDao;
import com.ocp.demo.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	EntityManager entityManger;

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee>  empList =  entityManger.createQuery("from Employee").getResultList();
		return empList;
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		Employee emp = entityManger.find(Employee.class, id);
		return emp;
		
	}

}
