package kngihts.thequestgame.knightsgame.domain.models;

import org.springframework.stereotype.Component;

@Component
public class PlayerInformation {

    private int gold = 0;

    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
}

