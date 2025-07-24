package com.product.ms_product.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.product.ms_product.security.ApiKeyAuthFilter;



@Configuration
public class ApplicationConfig {
    

    @Value("${app.security.api-key}")
    private String apiKey;

    @Value("${app.security.api-key-header}")
    private String apiKeyHeader;

    @Bean
    public ApiKeyAuthFilter apiKeyAuthFilter() {
        return new ApiKeyAuthFilter(apiKeyHeader, apiKey); // Ahora dinámico
    }

}
