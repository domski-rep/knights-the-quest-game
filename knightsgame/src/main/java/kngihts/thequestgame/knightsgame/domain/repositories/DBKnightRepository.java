package kngihts.thequestgame.knightsgame.domain.repositories;

import kngihts.thequestgame.knightsgame.domain.models.Knight;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.Optional;

public class DBKnightRepository implements KnightRepository {
    @Override
    public void createKnight(String name, int age) {
        throw new NotImplementedException();
    }

    @Override
    public Collection<Knight> getAllKnights() {
        throw new NotImplementedException();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteKnight(int id) {
        throw new NotImplementedException();
    }

    @Override
    public void build() {
        throw new NotImplementedException();
    }

    @Override
    public Knight getKnightById(Integer id) {
        throw new NotImplementedException();
    }
}
