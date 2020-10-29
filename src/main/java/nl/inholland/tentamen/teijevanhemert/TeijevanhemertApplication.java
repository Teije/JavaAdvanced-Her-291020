package nl.inholland.tentamen.teijevanhemert;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class TeijevanhemertApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(TeijevanhemertApplication.class, args);

		log.info("--- Exam Question 1 completed ---");
	}

}
