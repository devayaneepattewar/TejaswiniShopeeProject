package com.tejaswiniShopee.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		
	}
	
	
	
  	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable()

		.authorizeRequests()
		//.antMatchers("/customer/*").hasAuthority("ROLE_CUSTOMER")
		//.antMatchers("/admin/*").hasAuthority("ROLE_ADMIN")
		.antMatchers("/**").permitAll()// index.html
		.antMatchers("/").authenticated()

		.and().httpBasic()
		
		.and().formLogin()
		.defaultSuccessUrl("/customer/getCustomers",true)
		.permitAll()
		
		.and().logout().permitAll()
		;

	}
	
  	
  
  	@Bean
  	public BCryptPasswordEncoder passwordEncoder() {
  	    return new BCryptPasswordEncoder(4);
  	}
	//@Bean
	/*public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}*/
	
	/*public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/


}
