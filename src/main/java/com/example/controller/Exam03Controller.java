package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam3")
public class Exam03Controller {

	@Autowired
	private ServletContext application;

	@RequestMapping("")
	public String index() {
		return "exam03";
	}

	@RequestMapping("/result")
	public String result(int item1, int item2, int item3) {
		double tax = 1.1;
		int sum = item1 + item2 + item3;
		double taxSum = (item1 + item2 + item3) * tax;

		application.setAttribute("sum", sum);
		application.setAttribute("taxSum", taxSum);

		return "exam03-result";

	}
}
