package com.example.webapp.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/user/**").authenticated()
                .and().authorizeRequests().antMatchers("/match/all").permitAll()
                .and().authorizeRequests().antMatchers("/match", "/match/details*", "/match/edit*").authenticated()
                .and().authorizeRequests().antMatchers("/bet/**").authenticated()
                .and().formLogin()
                .and().logout()
                .and().csrf().disable()
                .addFilter(new BasicAuthenticationFilter());
    }
}
