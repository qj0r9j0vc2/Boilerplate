package com.qj0r9j0vc2.boilerplate.global.security.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import com.qj0r9j0vc2.boilerplate.global.security.filter.JwtExceptionHandlerFilter
import com.qj0r9j0vc2.boilerplate.global.security.filter.JwtFilter
import com.qj0r9j0vc2.boilerplate.global.security.jwt.provider.AccessTokenUtils
import com.qj0r9j0vc2.boilerplate.global.security.jwt.userDetails.CustomUserDetailsService
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@EnableWebSecurity
class SecurityConfig(
    private val customUserDetailsService: CustomUserDetailsService,
    private val jwtUtils: AccessTokenUtils,
    private val objectMapper: ObjectMapper
): WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            .cors().disable()
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/api/v1/auth/**").anonymous()
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(JwtFilter(customUserDetailsService, jwtUtils), UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(JwtExceptionHandlerFilter(objectMapper), JwtFilter::class.java)

    }

}