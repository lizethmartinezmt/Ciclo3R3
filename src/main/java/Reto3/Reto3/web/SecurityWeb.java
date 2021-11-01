/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3.Reto3.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

/**
 *
 * @author pampi
 */
@Configuration
public class SecurityWeb extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/", "/login.html", "/error", "/api/**","/images/**","/js/**","/css/**","/webjars/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().ignoringAntMatchers("/api/**", "/logout")
                .and().exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                .and().oauth2Login().defaultSuccessUrl("/habitacion.html", true)
                .and().logout().logoutSuccessUrl("/").permitAll();
    }
    
    
}
