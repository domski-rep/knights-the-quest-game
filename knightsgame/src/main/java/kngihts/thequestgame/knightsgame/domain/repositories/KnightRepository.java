package kngihts.thequestgame.knightsgame.domain.repositories;

import kngihts.thequestgame.knightsgame.domain.models.Knight;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Optional;

public interface KnightRepository {

    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void deleteKnight(int id);

    void build();

    Knight getKnightById(Integer id);

    default void updateKnight(int id, Knight knight){
        throw new NotImplementedException();
    }

}
