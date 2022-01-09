package com.star.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.star.entity.User;
import com.star.mapper.UserMapperR;



@Controller
public class LoginController {
	@Autowired
	private UserMapperR umr;
	
	@RequestMapping("/Login")
	public String login(HttpServletRequest request) {
		String name = request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		User us=umr.login(name);
		if(pwd.equals(us.getPwd())) {
			request.getSession().setAttribute("name", name);
			return "redirect:/index";
		}else {
			return "login";
		}
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		String name = (String) request.getSession().getAttribute("name");
		return "index";
	}
	
	@RequestMapping("/Logout")
	public String logout(HttpServletRequest request) {
		return "login";
	}
}

