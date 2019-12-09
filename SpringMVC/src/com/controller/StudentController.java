package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@RequestMapping("/showForm")
	public String showform(Model model) {

		model.addAttribute("student", new Student());

		return "student-form";
	}

	@RequestMapping("/processForm")
	public String registerStudent(@ModelAttribute("student") Student student) {
		System.out.println("inside the process student module...");
		return "student-confirm";
	}
}
