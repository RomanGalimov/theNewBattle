package com.Models;

/**
 * Created by GetAnUco on 16.01.2017.
 */
public class Headhunter implements Warrior, Cloneable {
    private int health = 100;
    private int damage = 110;
    private String name;
    private String squadName;

    public Headhunter(String name) {
        this.name = name;
    }

    private Headhunter(int health, int damage) {
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
    public Headhunter clone() {
        try {
            return (Headhunter) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }
}
