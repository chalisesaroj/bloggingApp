package com.udemy.learn.blogging.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class ConfigurationClass {
	@Autowired
	private UserDetailsService userDetailService;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeHttpRequests(authorize -> {
			authorize.anyRequest().authenticated();
		}).httpBasic();
		return http.build();
	}

	@Bean
	public AuthenticationManager authentication(AuthenticationConfiguration authenticationconfiguration)
			throws Exception {
		return authenticationconfiguration.getAuthenticationManager();
	}

//	@Bean
//UserDetailsService inmemoryauthman() {
//	UserDetails user1=User.builder().username("Saroj").password(this.passwordEncoder().encode("Saroj")).roles("ADMIN").build();
//	UserDetails user2=User.builder().username("Anzeela").password(this.passwordEncoder().encode("Anzeela")).roles("USER").build();
//	return new InMemoryUserDetailsManager(user1,user2);
//	
//}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
