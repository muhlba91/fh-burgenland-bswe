package io.muehlbachler.bswe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Entry point for the Spring Boot application.
 */
@SpringBootApplication
@EnableConfigurationProperties
public class App {

    /**
     * Starts the Spring Boot application.
     *
     * @param args command-line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }

    /**
     * Provides a {@link RestTemplate} bean for making REST calls.
     *
     * @return a new {@link RestTemplate} instance
     */
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}