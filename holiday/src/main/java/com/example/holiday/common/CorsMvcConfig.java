package com.example.holiday.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

        corsRegistry.addMapping("/**")
                .allowedOrigins("https://hansum.netlify.app","http://localhost:3000")
                .allowedMethods("*")
                .allowedHeaders("Authorization","Content-Type")
                .allowCredentials(true);
    }
}
