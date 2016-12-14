package com.Models;

public class Archer implements Warrior, Cloneable {
    private int health = 100;
    private int damage = 50;
    private String name;
    private String squadName;

    public Archer(String name) {
        this.name = name;
    }

    private Archer(int health, int damage) {
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

    public void setSquadName(String name) {
        squadName = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name + " из отряда " + squadName;
    }

    @Override
    public Archer clone() {
        try {
            return (Archer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
