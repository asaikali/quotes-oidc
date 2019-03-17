package com.example.quotes;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .oauth2Login()
                .loginPage("/oauth2/authorization/quotes")
                .failureUrl("/login?error")
                .permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("http://localhost:8090/uaa/logout.do?client_id=quotes&redirect=http://localhost:8080")
                .and()
            .oauth2Client();
    }
}