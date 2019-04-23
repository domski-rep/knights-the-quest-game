package kngihts.thequestgame.knightsgame.domain.repositories;

import kngihts.thequestgame.knightsgame.domain.models.Knight;
import kngihts.thequestgame.knightsgame.utils.Ids;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class InMemoryKnightRepository implements KnightRepository {

    Map<Integer, Knight> knights = new HashMap<>();

    public InMemoryKnightRepository() {

    }

    @Override
    public void createKnight(String name, int age) {
        Knight newKnight = new Knight(name, age);
        newKnight.setId(Ids.generateNewId(knights.keySet()));
        knights.put(newKnight.getId(), newKnight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Optional<Knight> knightByName = knights.values().stream().filter(knight -> knight.getName().equals(name)).findAny();

        return knightByName;
    }

    @Override
    public void deleteKnight(int id) {
        knights.remove(id);
    }

    @Override
    @PostConstruct
    public void build() {
        createKnight("John Snow", 29);
        createKnight("Ser Arthur Dayne", 25);
        createKnight("Dark Knight", 35);
        createKnight("Lancelot", 42);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }


    @Override
    public void updateKnight(int id, Knight knight) {
        knights.put(id, knight);
    }


    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knights +
                '}';
    }
}


