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
    }

    public boolean hasAliveWarriors() {
        for (Warrior warrior: warriors) {
            if (warrior.isAlive()) {
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
            Warrior[] newWarriors = new Warrior[this.warriors.length];
            for (int i = 0; i < newWarriors.length; i++) {
                newWarriors[i] = warriors[i].clone();
            }
            Squad squad = new Squad(this.name, newWarriors);
            return squad;
    }

}
