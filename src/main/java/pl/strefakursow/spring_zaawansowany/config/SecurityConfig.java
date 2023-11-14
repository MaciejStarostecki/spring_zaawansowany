package pl.strefakursow.spring_zaawansowany.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import pl.strefakursow.spring_zaawansowany.component.CustomDaoAuthenticationProvider;
import pl.strefakursow.spring_zaawansowany.service.implementation.JpaUserDetailSerice;


@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {

    JpaUserDetailSerice userDetailService;

    CustomDaoAuthenticationProvider authenticationProvider;

    @Autowired
    public SecurityConfig(JpaUserDetailSerice userDetailService, CustomDaoAuthenticationProvider authenticationProvider) {
        this.userDetailService = userDetailService;
        this.authenticationProvider = authenticationProvider;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/webjars/**").permitAll()
                        .requestMatchers("/admin_panel").hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/user_panel", true)
                        .permitAll()
                )
                .logout((logout) -> logout
                        .permitAll()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")

                );

        return http.build();
    }


}

