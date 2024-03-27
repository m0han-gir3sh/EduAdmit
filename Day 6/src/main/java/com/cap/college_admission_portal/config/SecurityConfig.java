package com.cap.college_admission_portal.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.cap.college_admission_portal.constant.*;
import com.cap.college_admission_portal.model.enumerate.Permission;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import java.util.*;
import java.util.stream.Collectors;

import static com.cap.college_admission_portal.model.enumerate.Permission.ADMIN_CREATE;
import static com.cap.college_admission_portal.model.enumerate.Permission.ADMIN_DELETE;
import static com.cap.college_admission_portal.model.enumerate.Permission.ADMIN_READ;
import static com.cap.college_admission_portal.model.enumerate.Permission.ADMIN_UPDATE;
import static com.cap.college_admission_portal.model.enumerate.Permission.STAFF_CREATE;
import static com.cap.college_admission_portal.model.enumerate.Permission.STAFF_DELETE;
import static com.cap.college_admission_portal.model.enumerate.Permission.STAFF_READ;
import static com.cap.college_admission_portal.model.enumerate.Permission.STAFF_UPDATE;
import static com.cap.college_admission_portal.model.enumerate.Permission.USER_CREATE;
import static com.cap.college_admission_portal.model.enumerate.Permission.USER_DELETE;
import static com.cap.college_admission_portal.model.enumerate.Permission.USER_READ;
import static com.cap.college_admission_portal.model.enumerate.Permission.USER_UPDATE;
import static com.cap.college_admission_portal.model.enumerate.Role.ADMIN;
import static com.cap.college_admission_portal.model.enumerate.Role.STAFF;
import static com.cap.college_admission_portal.model.enumerate.Role.USER;
import static org.springframework.http.HttpMethod.DELETE;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

        private final JwtAuthenticationFilter jwtAuthenticationFilter;
        private final AuthenticationProvider authenticationProvider;

        private static final String[] PublicEndPoints = {
                "/swagger-ui/**",
                "/swagger-ui.html/",
                "/v3/api-docs/**"
};

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
                httpSecurity

                                .csrf(AbstractHttpConfigurer::disable)
                                .authorizeHttpRequests(authorize -> authorize
                                                .requestMatchers(Api.AUTH + "/**").permitAll()
                                                .requestMatchers(PublicEndPoints).permitAll()
                                                .requestMatchers(Api.ADMIN + "/**")
                                                .hasRole(ADMIN.name())
                                                .requestMatchers(GET, Api.ADMIN + "/**")
                                                .hasAuthority(ADMIN_READ.name())
                                                .requestMatchers(POST, Api.ADMIN +"/**")
                                                .hasAuthority(ADMIN_CREATE.name())
                                                .requestMatchers(PUT , Api.ADMIN + "/**")
                                                .hasAuthority(ADMIN_UPDATE.name())
                                                .requestMatchers(DELETE , Api.ADMIN +"/**")
                                                .hasAuthority(ADMIN_DELETE.name())
                                                .requestMatchers(STAFF.name())
                                                .hasAnyRole(ADMIN.name() , STAFF.name())
                                                .requestMatchers(GET, Api.STAFF +"/**")
                                                .hasAnyAuthority(ADMIN_READ.name() , STAFF_READ.name())
                                                .requestMatchers(POST, Api.ADMIN +"/**")
                                                .hasAnyAuthority(ADMIN_CREATE.name(),STAFF_CREATE.name())
                                                .requestMatchers(PUT, Api.STUDENT +"/**")
                                                .hasAnyAuthority(ADMIN_UPDATE.name(),STAFF_UPDATE.name())
                                                .requestMatchers(GET, Api.STUDENT +"/**")
                                                .hasAnyAuthority(ADMIN_DELETE.name(),STAFF_DELETE.name())
                                                .requestMatchers(USER.name())
                                                .hasAnyRole(ADMIN.name(),USER.name() )
                                                .requestMatchers(GET, Api.ADMIN +"/**")
                                                .hasAuthority(USER_READ.name())
                                                .requestMatchers(POST, Api.ADMIN +"/**")
                                                .hasAnyAuthority(USER_CREATE.name(),ADMIN_CREATE.name())
                                                .requestMatchers(PUT, Api.ADMIN+"/**")
                                                .hasAuthority(USER_UPDATE.name())
                                                .requestMatchers(DELETE, Api.ADMIN +"/**")
                                                .hasAuthority(USER_DELETE.name())
                                                .anyRequest().authenticated())
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authenticationProvider(authenticationProvider)
                                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
                return httpSecurity.build();
        }

      
}
