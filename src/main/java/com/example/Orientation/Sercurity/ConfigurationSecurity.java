package com.example.Orientation.Sercurity;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfigurationSecurity extends WebSecurityConfigurerAdapter{
   @Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("user1").password("{noop}123").roles("USER");
//		auth.inMemoryAuthentication().withUser("zineb").password("{noop}1234").roles("USER","candidat");

		PasswordEncoder passwordEncoder  = passwordEncoder();
	    System.out.println("**********");
	    System.out.println(passwordEncoder.encode("123"));
	    System.out.println("le 1234 **********");
		auth.jdbcAuthentication()
	     .dataSource(dataSource)
	     .usersByUsernameQuery("select email as principal, password as credentials, operation from candidat where email=? ")
	     .authoritiesByUsernameQuery("select user as principal, role as role from user_role where user=?")
	     .passwordEncoder(passwordEncoder)
	     .rolePrefix("ROLE_");
	}        
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		http.authorizeRequests()
        .antMatchers("/monprofile","/mesMetiers")
        .hasRole("USER");		//http.authorizeRequests().anyRequest().authenticated();	
		http.authorizeRequests().antMatchers("/user/**").permitAll();
//		http.authorizeRequests().anyRequest().authenticated();
		
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
