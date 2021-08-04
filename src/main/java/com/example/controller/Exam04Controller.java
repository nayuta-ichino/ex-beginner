package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.UserForm;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

	// フォームクラスを使えるように準備
	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}

	@RequestMapping("")
	public String index() {
		return "exam04";
	}

	@RequestMapping("/result")
	public String result(UserForm userForm, Model model) {
		model.addAttribute("name", userForm.getName());
		model.addAttribute("age", userForm.getAge());
		model.addAttribute("comment", userForm.getComment());
		
		return "exam04-result";
	}
}
