package com.example.property.management.config;

import com.example.property.management.security.AccessDeniedJsonHandler;
import com.example.property.management.security.AdminUserDetailsService;
import com.example.property.management.security.DefaultLogoutSuccessHandler;
import com.example.property.management.security.LoginRequiredJsonAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
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
        authenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/**")
                .hasAuthority("ADMIN")
                .antMatchers("/api/**").authenticated()
                .and()
                .authenticationProvider(authenticationProvider())
                .formLogin()
                .loginProcessingUrl("api/admin/login")
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
        return new SimpleUrlAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler();
    }

}
