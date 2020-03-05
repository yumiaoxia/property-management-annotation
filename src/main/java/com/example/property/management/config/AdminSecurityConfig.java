package com.example.property.management.config;

import com.example.property.management.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;


@Configuration
@EnableWebSecurity
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminUserDetailsService adminUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminUserDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(adminUserDetailsService);
        authenticationProvider.setPasswordEncoder(new NoPasswordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.mvcMatcher("/api/**")
                .authorizeRequests()
                .antMatchers("/api/admin/login").permitAll()
                .antMatchers("/api/**").hasAnyAuthority("ADMIN", "PROADMIN")
                .and()
                .authenticationProvider(authenticationProvider())
                .formLogin()
                .loginProcessingUrl("/api/admin/login")
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                .and()
                .logout().logoutUrl("/api/admin/logout").logoutSuccessHandler(logoutSuccessHandler())
                .and()
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(loginRequiredJsonAuthenticationEntryPoint())
                .accessDeniedHandler(accessDeniedJsonHandler());
    }

    @Bean
    public AccessDeniedJsonHandler accessDeniedJsonHandler() throws Exception {
        return new AccessDeniedJsonHandler();
    }

    @Bean
    public LoginRequiredJsonAuthenticationEntryPoint loginRequiredJsonAuthenticationEntryPoint() {
        return new LoginRequiredJsonAuthenticationEntryPoint();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new DefaultLogoutSuccessHandler();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new AuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new AuthenticationFailureHandler();
    }

}
