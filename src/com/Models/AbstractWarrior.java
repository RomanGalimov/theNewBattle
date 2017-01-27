package com.Models; //в пакет warriors

import com.Models.Warriors.Archer;

public abstract class AbstractWarrior implements Warrior {

    private int health;
    private int damage;
    private String name;
    private String squadName;

    public AbstractWarrior(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int attack() {
        return damage;
    }

    public void takeDamage(int damage) {
        health-=damage;
    }

    public boolean isAlive() {
        return health>0;
    }

    @Override
    public int getHealth() {
        return health;
    }

    public void setSquadName(String name) {
        squadName = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + " из отряда " + squadName;
    }

    @Override
    public Warrior clone() {
        try {
            return (Warrior) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

}
