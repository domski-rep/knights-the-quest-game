package kngihts.thequestgame.knightsgame;

import kngihts.thequestgame.knightsgame.domain.repositories.KnightRepository;
import kngihts.thequestgame.knightsgame.domain.repositories.QuestRepository;
import kngihts.thequestgame.knightsgame.services.QuestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    KnightRepository knightRepository;
    @Autowired
    QuestRepository questRepository;
    @Autowired
    QuestService questService;

    @Override
    public void run(String... strings) throws Exception {

        questRepository.createRandomQuest();
        questRepository.createRandomQuest();
        questService.assignRandomQuest("Percival");

    }

}
