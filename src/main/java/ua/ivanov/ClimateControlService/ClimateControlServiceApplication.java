package ua.ivanov.ClimateControlService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"ua.ivanov"})
public class ClimateControlServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClimateControlServiceApplication.class, args);
	}

}
