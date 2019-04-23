package kngihts.thequestgame.knightsgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KnightsgameApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnightsgameApplication.class, args);
	}

}
