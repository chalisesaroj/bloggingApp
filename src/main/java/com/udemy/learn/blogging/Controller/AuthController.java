package com.udemy.learn.blogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.learn.blogging.payload.LoginDto;
import com.udemy.learn.blogging.payload.RegisterDto;
import com.udemy.learn.blogging.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationService authenticationService;
	@GetMapping("/login")
	
	public ResponseEntity<String>login(@RequestBody LoginDto loginDto){
		return new ResponseEntity
				(authenticationService.login(loginDto),HttpStatus.OK);
		
	}
	@PreAuthorize("hasAuthority('DEVELOPER')||hasAUTHORITY('ADMIN')")
	@PostMapping("/register")
	public ResponseEntity<String>login(@RequestBody RegisterDto registerDto){
		return new ResponseEntity
				(authenticationService.register(registerDto),HttpStatus.OK);
		
	}

}
