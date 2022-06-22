package com.study.eureka;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Date: 2022-06-16 星期四
 * Time: 17:11
 * Author: Dily_Su
 * Remark:
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 方式一： 弹窗登录
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http // 直接disable 会把安全验证也禁用，
//                .csrf().disable().authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }


    // 方式二：页内登录
//    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http); // 访问eureka 的控制台和/actuator 是可以做安全控制
        http.csrf().ignoringAntMatchers("/eureka/**"); //忽略eureka/**的所有请求
    }
}
