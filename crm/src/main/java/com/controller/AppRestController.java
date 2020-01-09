package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.Customer;
import com.service.CustomerService;

@RestController
@RequestMapping("/api")
public class AppRestController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/hello")
	public String sampleMethod() {
		return "Hello World!!";
	}

	@GetMapping("/customers")
	public List<Customer> customers() {
		return customerService.getCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public Customer customer(@PathVariable int customerId) {
		return customerService.getCustomer(customerId);
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setCustId(0);
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}

	@DeleteMapping("/customers/{customerId}")
	public List<Customer> deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
		return customerService.getCustomers();
	}
}
