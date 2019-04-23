package kngihts.thequestgame.knightsgame.configuration;

import kngihts.thequestgame.knightsgame.domain.repositories.DBKnightRepository;
import kngihts.thequestgame.knightsgame.domain.repositories.InMemoryKnightRepository;
import kngihts.thequestgame.knightsgame.domain.repositories.KnightRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class MainConfig {
    @Bean(name="inMemoryKnightRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepository(){
        KnightRepository repository = new InMemoryKnightRepository();
        return repository;
    }

    @Bean(name="DBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBKnightRepository(){
        KnightRepository repository = new DBKnightRepository();
        return repository;
    }

}
