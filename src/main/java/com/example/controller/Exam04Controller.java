package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.User;
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
	public String result(@Validated UserForm userForm, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return index();
		} else {
			User user = new User();
			BeanUtils.copyProperties(userForm, user);

			redirectAttributes.addFlashAttribute("user", user);

			return "redirect:/exam04/result2";
		}
	}

	@RequestMapping("/result2")
	public String result2() {
		return "exam04-result";
	}
}
