package com.theanimesh.blog.rest.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http
                .csrf(AbstractHttpConfigurer::disable)
                //added above line when was not able to post
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest()
                                .authenticated()
                )
                .httpBasic(Customizer.withDefaults());
        //Commented
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    //Added Above Lines When Throwed Some Error

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //@Bean
    //public UserDetailsService userDetailsService() {
    //    UserDetails ram = User.builder()
     //           .username("ram")
    //            .password(passwordEncoder().encode("1234"))
    //            .roles("USER")
    //            .build();

   //     UserDetails mark = User.builder()
   //             .username("mark")
   //             .password(passwordEncoder().encode("123"))
   //             .roles("USER")
   //             .build();
   //     UserDetails admin = User.builder()
   //             .username("admin")
   //             .password(passwordEncoder().encode("123"))
   //             .roles("ADMIN")
   //             .build();


    //    return new InMemoryUserDetailsManager(ram,mark, admin);
    //}

}