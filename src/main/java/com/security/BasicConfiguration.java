package com.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password("{noop}******")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("{noop}******")
                .roles("USER","ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

                http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/user/**")
                .hasRole("USER")
                .antMatchers("/admin**")
                .hasRole("ADMIN")
                .and().csrf().disable().headers().frameOptions().disable();

    }
}
