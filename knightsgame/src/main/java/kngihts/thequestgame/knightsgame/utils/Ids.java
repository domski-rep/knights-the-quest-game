package kngihts.thequestgame.knightsgame.utils;

import java.util.Set;

public class Ids {

    public static int generateNewId(Set<Integer> keysSoFar) {
        if (keysSoFar.isEmpty()) {
            return 0;
        }

        return keysSoFar.stream().max((one, two) -> one > two ? 1 : -1).get() + 1;
    }
}


