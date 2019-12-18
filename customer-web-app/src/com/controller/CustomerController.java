package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.Customer;
import com.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/fetchCustomers")
	public String showCustomers(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "show-customers";
	}

	@RequestMapping("/showFormToAdd")
	public String showFormToAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer/fetchCustomers";
	}

	@RequestMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("customerId") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "add-customer";
	}
	
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int id) {
		customerService.deleteCustomer(id);
		return "redirect:/customer/fetchCustomers";
	}
}
