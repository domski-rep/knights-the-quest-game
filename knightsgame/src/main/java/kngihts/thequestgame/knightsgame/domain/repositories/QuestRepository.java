package kngihts.thequestgame.knightsgame.domain.repositories;

import kngihts.thequestgame.knightsgame.domain.models.Quest;
import kngihts.thequestgame.knightsgame.utils.Ids;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class QuestRepository {


    private final static Random RANDOM = new Random();
    private Map<Integer, Quest> quests = new HashMap<>();

    public void createQuest(String description) {
        int newId = Ids.generateNewId(quests.keySet());
        Quest newQuest = new Quest(newId, description);
        quests.put(newId, newQuest);
    }

    public List<Quest> getAll() {
        return new ArrayList<>(quests.values());
    }

    public void deleteQuest(Quest quest) {
        quests.remove(quest.getId());
    }

    @Scheduled(fixedDelayString = "${questCreationDelay}")
    public void createRandomQuest() {

        List<String> description = new ArrayList<>();

        description.add("Save a Princess");
        description.add("Kill the Dragon");
        description.add("Kill some 'White Walkers'");
        description.add("Kill the Imp");
        description.add("Win the tournament");

        String randomQuestDescription = description.get(RANDOM.nextInt(description.size()));
        createQuest(randomQuestDescription);
    }

    public Quest getQuest(Integer id) {
        return quests.get(id);
    }

    @PostConstruct
    public void init() {

    }

    @Override
    public String toString() {
        return "QuestRepository{" +
                "questList=" + quests +
                '}';
    }

    public void update(Quest quest) {
        quests.put(quest.getId(), quest);
    }
}
