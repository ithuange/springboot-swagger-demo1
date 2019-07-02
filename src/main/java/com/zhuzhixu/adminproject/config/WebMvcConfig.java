package com.zhuzhixu.adminproject.config;

import com.zhuzhixu.adminproject.beancomponent.SettingLocaleResolver;
import com.zhuzhixu.adminproject.interceptor.UserInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**.do/**").excludePathPatterns("/login.do","/register.do");

    }

    /**
     *
     * @return 返回localeResolver 处理国际化
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new SettingLocaleResolver();
    }



}
