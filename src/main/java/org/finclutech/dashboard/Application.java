package org.finclutech.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.finclutech.dashboard", "org.finclutech.dashboard.init"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}