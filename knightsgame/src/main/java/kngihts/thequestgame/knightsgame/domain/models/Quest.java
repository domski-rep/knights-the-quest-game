package kngihts.thequestgame.knightsgame.domain.models;

import java.time.LocalDateTime;

public class Quest {

    private int id;
    private String description;
    private int reward = 100;
    private boolean isStarted = false;
    private boolean isEnded = false;
    private boolean isCompleted;
    protected int lengthInSeconds = 10;
    protected LocalDateTime startDate;

    public Quest(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        if (started) {
            this.startDate = LocalDateTime.now();
        }
        isStarted = started;
    }

    public boolean isEnded() {
        return isEnded;
    }

    public void setEnded(boolean ended) {
        isEnded = ended;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCompleted() {

        if (this.isCompleted) {
            return this.isCompleted;
        } else {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime deadline = this.startDate.plusSeconds(this.lengthInSeconds);
            boolean isAfter = now.isAfter(deadline);

            if (isAfter) {
                this.isCompleted = true;
            }
            return isAfter;
        }
    }

    @Override
    public String toString() {
        return description;
    }


}
