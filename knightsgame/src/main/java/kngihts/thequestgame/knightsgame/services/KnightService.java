package kngihts.thequestgame.knightsgame.services;


import kngihts.thequestgame.knightsgame.domain.models.Knight;
import kngihts.thequestgame.knightsgame.domain.models.PlayerInformation;
import kngihts.thequestgame.knightsgame.domain.repositories.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class KnightService {

    @Autowired
    KnightRepository knightRepository;
    @Autowired
    PlayerInformation playerInformation;

    public List<Knight> getAllKnights() {
        return new ArrayList<>(knightRepository.getAllKnights());

    }

    public void saveKnight(Knight knight) {
        knightRepository.createKnight(knight.getName(), knight.getAge());
    }

    public Knight getKnight(Integer id) {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {


        Predicate <Knight> knightPredicate = knight -> {
            if (knight.getQuest() != null) {
                return   knight.getQuest().isCompleted();
            }else {
                return false;
            }
        };

        int collectedRewards = knightRepository.getAllKnights().stream()
                .filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward())
                .sum();
        knightRepository.getAllKnights().stream()
                .filter(knightPredicate).forEach(knight -> knight.setQuest(null));

        return collectedRewards;
    }

    public void getMyGold() {

        List<Knight> allKnights = getAllKnights();
        allKnights.forEach((knight) -> {
            if (knight.getQuest() != null) {
                knight.getQuest().isCompleted();
            }
        });

        int currentGold = playerInformation.getGold();
        playerInformation.setGold(currentGold + collectRewards());
    }
}
