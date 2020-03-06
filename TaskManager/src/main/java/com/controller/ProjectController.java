package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.EmployeeService;
import com.service.ProjectService;
import com.service.TaskService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private TaskService taskService;

	@RequestMapping("/")
	public String showPage() {
		return "index";
	}

	@RequestMapping("/home")
	public String homePage() {
		return "redirect:/";
	}
	
	@RequestMapping("/jqueryPage")
	public String showJqueryTestPage() {
		return "JqueryTestPage";
	}


	@RequestMapping("/assignTasks")
	public String assignTasks(Model model) {
		return "assign-tasks";
	}

	@RequestMapping("/taskAssignment")
	public String taskAssignment() {
		return "redirect:/assignTasks";
	}

	@RequestMapping("/viewTasks")
	public String viewTasks() {
		return "view-tasks";
	}
}
