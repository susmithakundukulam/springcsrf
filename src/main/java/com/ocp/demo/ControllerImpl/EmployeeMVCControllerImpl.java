package com.ocp.demo.ControllerImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.ocp.demo.Controller.EmployeeMVCController;
import com.ocp.demo.model.Users;

@Controller
public class EmployeeMVCControllerImpl implements EmployeeMVCController{

	@Override
	public String EmployeePage(ModelMap map) {
		return "employee-page";
	}

	@Override
	public String userPage(ModelMap map, HttpServletRequest request) {
		System.out.println("**********************userPage***********************");
		System.out.println(request.getParameter("username"));
		return "user-page";
	}

	@Override
	public String adminPage(ModelMap map) {
		return "admin-page";
	}

}
