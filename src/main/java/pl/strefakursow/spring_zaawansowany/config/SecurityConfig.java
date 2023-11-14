package pl.strefakursow.spring_zaawansowany.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pl.strefakursow.spring_zaawansowany.service.implementation.JpaUserDetailSerice;


@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig {

    JpaUserDetailSerice userDetailService;

    @Autowired
    public SecurityConfig(JpaUserDetailSerice userDetailService) {
        this.userDetailService = userDetailService;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                    .authorizeRequests()
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/login")).permitAll()
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/webjars/**")).permitAll()
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/sing_up")).permitAll()
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/admin_panel")).hasAuthority("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/user_panel", true)
                )
                .logout((logout) -> logout
                        .permitAll()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")

                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

