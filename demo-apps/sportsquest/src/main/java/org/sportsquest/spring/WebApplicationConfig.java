package org.sportsquest.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.sportsquest.web.controllers.HelloWorldController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = HelloWorldController.class)
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WebContentInterceptor());
        //registry.addInterceptor(new ThemeInterceptor()).addPathPatterns("/").excludePathPatterns("/admin/");
        //registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/secure/*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/", "classpath:/META-INF/public-web-resources/");
    }
}