package com.cg.spring.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.model.AppUser;
import com.cg.spring.boot.demo.service.AppUserService;

//@Component
@RestController
public class AppUserController {

	private static final Logger LOG = LoggerFactory.getLogger(AppUserController.class);

	@Autowired
	private AppUserService AppUserService;

	@PostMapping("/register")
	public ResponseEntity<AppUser> register(@RequestBody AppUser appUser) {
		LOG.info("Controller register");
		AppUser emp = AppUserService.register(appUser);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This employee is register to database.");
		LOG.info(headers.toString());
		ResponseEntity<AppUser> response = new ResponseEntity<AppUser>(emp, headers, HttpStatus.CREATED);
		return response;
	}
	
	@PostMapping("/login")
	public ResponseEntity<AppUser> login(@RequestBody AppUser appUser) {
		LOG.info("Controller login");
		AppUser emp = AppUserService.login(appUser);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This employee is login.");
		LOG.info(headers.toString());
		ResponseEntity<AppUser> response = new ResponseEntity<AppUser>(emp, headers, HttpStatus.OK);
		return response;
	}
	
}