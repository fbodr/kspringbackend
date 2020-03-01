package org.example.kspringbackend.security

import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager

@Configuration
@EnableWebSecurity
class BasicAuthSecurity: WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        val encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
        auth.inMemoryAuthentication()
            .withUser("user")
            .password(encoder.encode("password"))
            .roles("USER")
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/private/basic").hasRole("USER")
            .and()
            .httpBasic()
    }
}
