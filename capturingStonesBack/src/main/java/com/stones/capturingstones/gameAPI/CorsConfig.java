package com.stones.capturingstones.gameAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/captureStones/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST"); // Add other allowed methods as needed
            }
        };
    }
}
