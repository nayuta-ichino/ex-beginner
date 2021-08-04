package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.repository.MemberRepository;

@Controller
@RequestMapping("/exam05")
public class Exam05Controller {
	
	@Autowired
	private MemberRepository repository;

	@RequestMapping("")
	public String index() {
		return "exam05";
	}
	
	@RequestMapping("/result")
	public String result(String search, Model model) {
		List<Member> memberList = repository.searchAll(search);
		model.addAttribute("memberList", memberList);
		
		if(memberList.size() == 0) {
			return "exam05-result-null";
		}
	
		return "exam05-result";
	}
	
}
