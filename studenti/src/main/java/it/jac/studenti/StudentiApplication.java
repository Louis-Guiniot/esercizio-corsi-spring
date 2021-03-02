package it.jac.studenti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = "it.jac.studenti")
public class StudentiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentiApplication.class, args);
	}

}
