package com.bin.springboot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.springboot.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bin.springboot.core.PageInfo;
import com.bin.springboot.core.ResBody;
import com.bin.springboot.service.UserService;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController{

	@Autowired
	private UserService userService;

	@RequestMapping("/saveUser")
	public String saveUser(User user) {
		userService.saveUser(user);
		return "success";
	}

	@RequestMapping("/findUser")
	public User findUser(User user) {
		User returnUser = userService.findUser(user.getId());
		return returnUser;
	}

	@RequestMapping("/findAllUser")
	public List<User> findAllUser(User user) {
		return userService.findAllUser(user);
	}

	@RequestMapping("/findUserPage")
	@PreAuthorize("hasAnyAuthority('test1Role')")
	public ResBody findUserPage(User user, @Validated PageInfo pageInfo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return getValidatedInfo(bindingResult);
		}
		return ResBody.buildSuccessResBody(userService.findUserPage(user, pageInfo).getContent());
	}

	@RequestMapping("/removeUser")
	public String removeUser(User user, HttpServletRequest req) {
		req.getHeader("Authorization_");
		log.info("zzpps");
		log.error("sssqq");
		userService.removeUser(user.getId());
		return "success";
	}
	@RequestMapping(value = "/userTest")
	public String userTest() throws Exception{
		throw new Exception("test");
	//	return "success";
	}


}
