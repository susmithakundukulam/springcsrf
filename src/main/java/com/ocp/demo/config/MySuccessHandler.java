package com.ocp.demo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class MySuccessHandler implements AuthenticationSuccessHandler{
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		authentication.getAuthorities().forEach(authority -> {
			if(authority.getAuthority().equals("ROLE_USER")) {
				try {  
					//response.sendRedirect("/user");
					redirectStrategy.sendRedirect(request, response, "/empMvc/userPage");

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if(authority.getAuthority().equals("ROLE_ADMIN")) {
				try {
					//response.sendRedirect("/admin");
					redirectStrategy.sendRedirect(request, response, "/empMvc/adminPage");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
	            throw new IllegalStateException();
	        }
		});
		
	}

}
