package com.sx.guanli.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // 暂时禁用所有安全检查
        http
            .csrf(csrf -> csrf.disable())  // 禁用CSRF保护
            .cors(withDefaults())          // 启用CORS
            .authorizeHttpRequests(auth -> 
                auth.anyRequest().permitAll()  // 允许所有请求
            );
            
        /* 后续可以取消注释启用安全检查
        http
            .csrf(csrf -> csrf.disable())
            .cors(withDefaults())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login").permitAll()  // 登录接口允许匿名访问
                .anyRequest().authenticated()           // 其他所有请求需要认证
            )
            .formLogin(form -> form
                .loginProcessingUrl("/login")  // 登录接口
                .successHandler((request, response, authentication) -> {
                    // 登录成功处理
                })
                .failureHandler((request, response, exception) -> {
                    // 登录失败处理
                })
            );
        */
            
        return http.build();
    }
    
    /* 后续可以取消注释启用密码加密
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    */
}
