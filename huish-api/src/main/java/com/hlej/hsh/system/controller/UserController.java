package com.hlej.hsh.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hlej.hsh.system.entity.User;
import com.hlej.hsh.system.service.UserService;

@Controller
@RequestMapping("/test")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/regiester")
	public String regiester(@RequestHeader HttpHeaders headers,@RequestBody User user) {
		userService.saveUser(user);
		return "regiester";
	}
}
