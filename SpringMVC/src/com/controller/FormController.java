package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "show-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "process-form";
	}

	@RequestMapping("/customProcessForm")
	public String customformProcess(HttpServletRequest request, Model model) {

		String name = request.getParameter("studentName");

		String nameModified = "Yo! " + name.toUpperCase();

		model.addAttribute("message", nameModified);

		return "processed-form";
	}
}
