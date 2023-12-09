package ru.runplanner.user.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityBeans {

    @Bean
    SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/index","/registration").permitAll()
                        .requestMatchers("/user/{id}/dashboard").authenticated())
                .formLogin(form -> form.loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
