package com.crm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().disable();
        http.csrf().disable();
//        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and
//                ().httpBasic();
             http.authorizeRequests().antMatchers("/**").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("recruiter1").password("{noop}1234").roles("USER");
        auth.inMemoryAuthentication().withUser("recruiter2").password("{noop}1234").roles("USER");
    }


}
