package kngihts.thequestgame.knightsgame.domain.models;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Knight {


    private int id;

    @NotNull
    @Size(min = 2, max = 40, message = "The Knight name must contain from 2 to 40 characters")
    private String name;
    @NotNull
    @Range(min = 18, max = 59, message = "Knight must be at least 18 years old and younger than 60")
    private int age;
    private int level = 1;
    private Quest quest;

    public Knight() {
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Knight(String name, int age, int level) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        if (quest != null) {
            quest.setStarted(true);
        }
        this.quest = quest;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
