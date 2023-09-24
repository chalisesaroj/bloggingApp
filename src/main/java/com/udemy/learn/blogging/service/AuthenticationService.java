package com.udemy.learn.blogging.service;

import com.udemy.learn.blogging.payload.LoginDto;
import com.udemy.learn.blogging.payload.RegisterDto;

public interface AuthenticationService {
	String login(LoginDto loginDto);
	String register(RegisterDto regisreDto);

}
