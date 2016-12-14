package com.Models;

public class Mage implements Warrior, Cloneable {
    private int health = 80;
    private int damage = 70;
    private String name;
    private String squadName;

    public Mage(String name) {
        this.name = name;
    }

    private Mage(int health, int damage) {
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
    public Mage clone() {
        try {
            return (Mage) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
