package ru.runplanner.user.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.runplanner.user.model.User;
import ru.runplanner.user.storage.UserRepository;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class UserInfoUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findUserByEmail(email);

        return user.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User with email=" + email + " not found"));
    }
}