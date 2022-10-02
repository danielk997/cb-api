package com.example.sample.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.web.cors.CorsConfiguration;

@EnableWebSecurity
public class OAuth2ResourceServerSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config = http.authorizeRequests();
        config
                .antMatchers("/").permitAll()
                .and()
                .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and()
                .oauth2ResourceServer().jwt(); // replace .jwt() with .opaqueToken() for Opaque Token case

        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
    }
}