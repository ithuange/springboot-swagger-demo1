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
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/").excludePathPatterns("/login");
    }

    /**
     *
     * @return 返回localeResolver 处理国际化
     * 因为是自定义的localrosolver默认不带参数的时候会使用系统的国际化
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new SettingLocaleResolver();
    }

}
