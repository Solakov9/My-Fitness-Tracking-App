package org.myfitnesstrackingapp.config;

import lombok.RequiredArgsConstructor;
import org.myfitnesstrackingapp.service.UserDetailsServiceImpl;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(
                        authorizeRequest -> {
                            authorizeRequest
                                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                    .requestMatchers("/", "/users/login","/users/login-error","/access-denied", "/users/register").permitAll()
                                    .requestMatchers("/users/add-workout").hasRole("INSTRUCTOR")
                                    .requestMatchers("/add-diet").hasRole("INSTRUCTOR")
                                    .anyRequest().authenticated();
                        }
                )
                .formLogin(formLogin -> {
                    formLogin.loginPage("/users/login");
                    formLogin.usernameParameter("username");
                    formLogin.passwordParameter("password");
                    formLogin.defaultSuccessUrl("/home",true);
                    formLogin.failureUrl("/users/login-error");
                })
                .logout(logout ->{
                    logout.logoutUrl("/users/logout");
                    logout.logoutSuccessUrl("/");
                    logout.invalidateHttpSession(true);
                })
                .userDetailsService(userDetailsService)

                .build();

    }
}
