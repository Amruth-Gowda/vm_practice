package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {
	@RequestMapping("/")
	public String showPage() {
		return "index";
	}

	@RequestMapping("/home")
	public String homePage() {
		return "redirect:/";
	}

	@RequestMapping("/assignTasks")
	public String assignTasks() {
		return "assign-tasks";
	}
	
	@RequestMapping("/viewTasks")
	public String viewTasks() {
		return "view-tasks";
	}
}
