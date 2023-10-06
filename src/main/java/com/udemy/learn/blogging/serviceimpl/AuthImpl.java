package com.udemy.learn.blogging.serviceimpl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udemy.learn.blogging.entity.User;
import com.udemy.learn.blogging.exception.DataAlreadyExists;
import com.udemy.learn.blogging.entity.Role;
import com.udemy.learn.blogging.payload.LoginDto;
import com.udemy.learn.blogging.payload.RegisterDto;
import com.udemy.learn.blogging.repository.RoleRepository;
import com.udemy.learn.blogging.repository.UserRepository;
import com.udemy.learn.blogging.service.AuthenticationService;

@Service
public class AuthImpl implements AuthenticationService {

	private AuthenticationManager authenticationManager;
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;

	public AuthImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
			RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		super();
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
	}

	@Override
	public String login(LoginDto loginDto) throws AuthenticationException {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUserNameOrEmail(), loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return "Succefully logged in";
	}

	@Override
	@Transactional
	public String register(RegisterDto registerDto) {
	    // Check if email or username already exist
	    if (userRepository.existsByEmail(registerDto.getEmail())) {
	        return "Email already exists";
	    }
	    if (userRepository.existsByUserName(registerDto.getUserName())) {
	        return "Username already exists";
	    }

	    User user = new User();
	    user.setEmail(registerDto.getEmail());
	    user.setName(registerDto.getName());
	    user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
	    user.setUserName(registerDto.getUserName());
	    userRepository.save(user);
	    Set<Role> roles = new HashSet<>(registerDto.getRole());
	    roles.stream().filter((role)->!roleRepository
	    		.existsByName(role.getName())).collect(Collectors.toSet())
	    		.forEach(role->roleRepository.save(role));;
 
	 	Set<Role>settingRole=new HashSet();
	 	registerDto.getRole().forEach((role)->{
		Role role1=roleRepository.findByName(role.getName()).orElseThrow();
		settingRole.add(role1);
	});
	   user.setRole(settingRole);
	    userRepository.save(user);

	    return "Successfully registered";
	}


}
