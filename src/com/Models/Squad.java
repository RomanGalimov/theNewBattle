package com.Models;

public class Squad implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    private Warrior[] warriors;

    public Squad(String name, Warrior[] warriors) {
        this.name = name;
        this.warriors = warriors;
        for (int i = 0; i < warriors.length; i++) {
            warriors[i].setSquadName(name);
        }
    }

    public boolean hasAliveWarriors() {
        for (int i = 0; i < warriors.length; i++) {
            if (warriors[i].isAlive()) {
                return true;
            }
        }
        return false;
    }

    Warrior getRandomWarrior() {
        boolean found = false;
        Warrior foundWarrior = null;
        int num;
        while (!found) {
            num = (int) (Math.random()*warriors.length);
            if (warriors[num].isAlive()) {
                foundWarrior = warriors[num];
                found = true;
            }
        }
        return foundWarrior;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Squad clone() {
        try {
            return (Squad) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

}
