package com.example.demo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
 
@Configuration
public class PathConfig extends WebMvcConfigurerAdapter{
 
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("file:G:\\Java-workbench\\schoolrun\\src\\main\\resources\\static\\");
        super.addResourceHandlers(registry);
    }
 
}