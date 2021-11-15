package com.mvp.crud.security;

import com.mvp.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
                .inMemoryAuthentication()
                .withUser("user")
                //.password(encoder.encode("ammar"))
                .password("ammar")
                .roles("USER")
                .and()
                .withUser("admin")
                //.password(encoder.encode("ammar"))
                .password("ammar")
                .roles("USER", "ADMIN").and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
                //deprecated but for demo purposes, otherwise use the above PasswordEncoder encoder
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()//to allow all HTTP methods
                .authorizeRequests()
                    .antMatchers("/api/frg/**").hasRole("USER")
//                    .antMatchers("/api/frg/spouse").hasRole("USER")
//                .antMatchers("/api/frg/soldier").hasRole("ADMIN")
//                .antMatchers("/api/frg/spouse").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                    .permitAll()
                    .and()
                .httpBasic();
    }
}
/*
//still needs re-factor to use Spring Security UserDetailsService interface to user a custom user service with database
//instead of in-memory authentication
https://stackoverflow.com/questions/67065093/springboot-application-properties-file-with-multiple-users-passwords-roles

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
}

 */
