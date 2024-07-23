package org.myfitnesstrackingapp.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(
                        authorizeRequest -> {
                            authorizeRequest
                                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                    .requestMatchers("/", "/users/login","/users/login-error", "/users/register").permitAll()
                                    .anyRequest().authenticated();
                        }
                )
                .formLogin(formLogin -> {
                    formLogin.loginPage("/users/login");
                    formLogin.usernameParameter("username");
                    formLogin.passwordParameter("password");
                    formLogin.defaultSuccessUrl("/",true);
                    formLogin.failureUrl("/users/login-error");
                })
                .logout(logout ->{
                    logout.logoutUrl("/users/logout");
                    logout.invalidateHttpSession(true);
                    logout.logoutSuccessUrl("/");
                })

                .build();

    }
}