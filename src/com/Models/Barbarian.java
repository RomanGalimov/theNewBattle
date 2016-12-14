package com.Models;

public class Barbarian implements Warrior, Cloneable {
    private int health = 120;
    private int damage = 30;
    private String name;
    private String squadName;


    public Barbarian(String name) {
        this.name = name;
    }

    private Barbarian (int health, int damage) {
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
        return getClass().getSimpleName() + " " +  name +  " из отряда " + squadName;
    }

    @Override
    public Barbarian clone() {
        try {
            return (Barbarian)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
