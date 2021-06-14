package com.ocp.demo.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/empMvc")
public interface EmployeeMVCController {
	
	@RequestMapping(value = "/showLoginPage", method = RequestMethod.GET)
	public String EmployeePage(ModelMap map);
	
	@RequestMapping(value = "/userPage", method = RequestMethod.GET)
	public String userPage(ModelMap map);
	
	@RequestMapping(value = "/adminPage", method = RequestMethod.GET)
	public String adminPage(ModelMap map);

}
