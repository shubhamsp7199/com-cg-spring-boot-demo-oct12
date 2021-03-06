package com.cg.spring.boot.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.AppUserAlreadyExistsException;
import com.cg.spring.boot.demo.model.AppUser;
import com.cg.spring.boot.demo.repository.AppUserRepository;

@Service
public class AppUserService {

	// please check the logic 
	
	
	private static final Logger LOG = LoggerFactory.getLogger(AppUserService.class);

	@Autowired
	AppUserRepository appUserRepository;

	public  AppUser register(AppUser appUser) {
		LOG.info("register");
		if (! appUserRepository.existsById(appUser.getUid()))
			return appUserRepository.save(appUser);
		else
			throw new AppUserAlreadyExistsException(appUser.getUid() + " This User Already Exits.");
	}

	public  AppUser login(AppUser appUser) {
		LOG.info("login");
		if (! appUserRepository.existsById(appUser.getUid()))
			return appUserRepository.save(appUser);
		else
			throw new AppUserAlreadyExistsException(appUser.getUid() + " This User Already Exits.");
	}
}