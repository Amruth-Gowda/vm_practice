package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.CustomerDAO;
import com.dto.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/fetchCustomers")
	public String showCustomers(Model model) {
		
		List<Customer> customers = customerDAO.getCustomers();
		model.addAttribute("customers", customers);
		return "show-customers";
		
	}
}
