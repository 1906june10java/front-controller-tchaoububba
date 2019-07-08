package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Customer;
import com.revature.service.CustomerService;

public class CustomerController {
	
	/*
	 * Dependency
	 */
	private static CustomerService customerService = new CustomerService();
	
	public static Object getAllCustomers(HttpServletRequest request) {
		//Calls the service which calls the DAO to get the list of customers
		return customerService.listAllCustomers();
	}
	
	public static Object register(HttpServletRequest request) {
		if(request.getMethod().equals("GET")) {
			return "register.html";
		}
		/*At this point, the request must have been POST*/
		//request.getInputStream()
		
		//new ObjectMapper().method(string, Customer.class)
		
		customerService.register(new Customer(0, request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("username"), request.getParameter("password")));
		
		return "REGISTRATION_SUCCESSFUL";
	}

}
