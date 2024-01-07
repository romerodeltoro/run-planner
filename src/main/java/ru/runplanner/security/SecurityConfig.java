package ru.runplanner.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ru.runplanner.user.service.CustomUserDetailsService;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService userService;

    public CustomAuthSuccessHandler successHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/**").permitAll())
                .formLogin(form -> form
                        .loginPage("/signin")
                        .loginProcessingUrl("/userLogin")
                        .successHandler(successHandler).permitAll())
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(getEncoder());
        return provider;
    }
    @Bean
    public BCryptPasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

}
