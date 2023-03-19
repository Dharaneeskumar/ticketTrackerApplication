package com.glproject.tickettrackingsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.FilterChain;

@Configuration
@EnableWebSecurity
public class SecurityCongfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
public UserDetailsService userDetailsService(){
    UserDetails adminUser= User.withUsername("admin")
            .password(passwordEncoder().encode("admin")).roles("ADMIN").build();
        UserDetails user= User.withUsername("user")
                .password(passwordEncoder().encode("user")).roles("USER").build();

   return new InMemoryUserDetailsManager(adminUser,user);
}
@Bean
    public SecurityFilterChain filterChain(HttpSecurity  httpSecurity) throws Exception {

httpSecurity.csrf().disable()
        .authorizeHttpRequests()
        .mvcMatchers("/ticketPage/getAllTickets").hasRole("ADMIN")
        .mvcMatchers("/ticketPage/createTicket/**").hasRole("USER")
        .antMatchers("/ticketPage/home")
        .permitAll().anyRequest().authenticated()
        .and().formLogin().and().logout().logoutSuccessUrl("/ticketPage/home");


return httpSecurity.build();
}
}
