package org.finclutech.dashboard;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.text.SimpleDateFormat;

@SpringBootApplication
@ComponentScan(basePackages = {"org.finclutech.dashboard", "org.finclutech.dashboard.init"})
public class Application {
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy HH:mm"));
        return mapper;
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}