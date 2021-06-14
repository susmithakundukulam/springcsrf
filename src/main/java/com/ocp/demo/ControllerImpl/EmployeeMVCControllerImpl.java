package com.ocp.demo.ControllerImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.ocp.demo.Controller.EmployeeMVCController;

@Controller
public class EmployeeMVCControllerImpl implements EmployeeMVCController{

	@Override
	public String EmployeePage(ModelMap map) {
		return "employee-page";
	}

	@Override
	public String userPage(ModelMap map) {
		return "user-page";
	}

	@Override
	public String adminPage(ModelMap map) {
		return "admin-page";
	}

}
