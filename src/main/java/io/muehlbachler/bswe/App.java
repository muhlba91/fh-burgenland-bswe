package io.muehlbachler.bswe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Spring Boot application.
 */
@SpringBootApplication
public class App {
    /**
     * Main method.
     * 
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }
}
