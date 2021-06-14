package com.ocp.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	MySuccessHandler mySuccessHandler;

	@Autowired
	private DataSource secDataSource;
	//-----------------------------------------------------------------------------------------
	//Incase if you need role and login to be in different table say users,authorities
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { //add our users for in memory authentication
	 * 
	 * //above spring version 5... withDefaultPasswordEncoder is deprecated . so
	 * ignore warning //Rough Code for hard coding login credentials
	 * 
	 * UserBuilder users = User.withDefaultPasswordEncoder();
	 * auth.inMemoryAuthentication()
	 * .withUser(users.username("susmitha").password("test123").roles("EMPLOYEE"))
	 * .withUser(users.username("tom").password("test123").roles("EMPLOYEE",
	 * "MANAGER"))
	 * .withUser(users.username("christo").password("test123").roles("ADMIN"));
	 * 
	 * 
	 * //code for login credentials to get from database
	 * System.out.println("************************secDataSource");
	 * auth.jdbcAuthentication().dataSource(secDataSource);
	 * 
	 * }
	 */
	//-----------------------------------------------------------------------------------------
	
	//Incase if you need role and login to be in one table
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()).dataSource(secDataSource)
				.usersByUsernameQuery("select username, password, enabled from users where username=?")
		 .authoritiesByUsernameQuery("select username, role from users where username=?")
		;  
	}  
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		//.csrf().disable()
		
		.authorizeRequests().anyRequest().authenticated()
		
		.and()
		
		.formLogin()
		.loginPage("/empMvc/showLoginPage")
		.loginProcessingUrl("/authenticateTheUser")//  : springsecurity filters wil handle
		//.defaultSuccessUrl("/empMvc/showLoginPage", true) //after successful login redirect to this url
		.successHandler(mySuccessHandler)
		.permitAll()
		
		.and()
		.logout().permitAll(); // /logout : springsecurity filters wil handle
	}

}
