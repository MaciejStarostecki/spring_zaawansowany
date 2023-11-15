package pl.strefakursow.spring_zaawansowany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringZaawansowanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZaawansowanyApplication.class, args);
	}

}
