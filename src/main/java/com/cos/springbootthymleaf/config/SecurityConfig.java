package com.cos.springbootthymleaf.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }

    // IoC등록만 하면 AuthenticationManager가 Bcrypt로 자동 검증해줌.
    @Bean
    public BCryptPasswordEncoder encode(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // CSRF : 사용자가 자신의 의지와는 무관하게 공격자가 의도한 행위를 특정 웹사이트에 요청하도록 하는 것
        // CSRF 공격을 방어하기 위한 대표적인 방법 : Referrer 검증, Spring Security CSRF Token 사용
        // 스프링 시큐리티에서는 @EnableWebSecurity 어노테이션을 지정할 경우 자동으로 CSRF 보호 기능이 활성화
        http.csrf().disable(); // CSRF 비활성화 하겠다는 의미
        // 리소스(URL)의 권한 설정
        http.authorizeRequests()
                .antMatchers("/user/**","/post/**", "/reply/**")// 특정 리소스에 대한 권한 설정
                .access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") // 해당 권한을 가진 사용자만 접근을 허용하겠다.
                .antMatchers("/admin/**")
                .access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll() // 나머지 요청은 어떠한 보안 요구 없이 요청을 허용하겠다.
                .and()
                .formLogin()// 일반적인 폼 로그인을 사용하겠다. x-www-form-urlencoded 로 전송 (json x)
                .loginPage("/loginForm")// 사용자가 따로 만든 로그인 페이지를 사용
                .loginProcessingUrl("/login")// 로그인 처리를 하는 URL을 설정
                .defaultSuccessUrl("/"); // 인증에 성공했을 경우 이동하는 페이지 설정

        http.headers().frameOptions().disable();
    }
}
