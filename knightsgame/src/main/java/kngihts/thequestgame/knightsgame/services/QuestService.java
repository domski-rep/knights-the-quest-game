package kngihts.thequestgame.knightsgame.services;

import kngihts.thequestgame.knightsgame.domain.models.Quest;
import kngihts.thequestgame.knightsgame.domain.repositories.KnightRepository;
import kngihts.thequestgame.knightsgame.domain.repositories.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuestService {


    @Autowired
    KnightRepository knightRepository;

    QuestRepository questRepository;

    final static Random RAND = new Random();


    public void assignRandomQuest(String knightName){
        List<Quest> allQuests = questRepository.getAll();
        Quest randomQuest = allQuests.get(RAND.nextInt(allQuests.size()));
        knightRepository.getKnight(knightName).ifPresent(knight -> knight.setQuest(randomQuest));
        questRepository.deleteQuest(randomQuest);
    }

    public List<Quest> getAllNotStartedQuests() {
        return questRepository.getAll().stream().filter(quest -> !quest.isStarted()).collect(Collectors.toList());
    }

    @Autowired
    public void setQuestRepository(QuestRepository questRepository) {
        this.questRepository = questRepository;
    }

    public void update(Quest quest) {
        questRepository.update(quest);
    }

    public boolean isQuestCompleted(Quest quest){
        return quest.isCompleted();
    }
}
