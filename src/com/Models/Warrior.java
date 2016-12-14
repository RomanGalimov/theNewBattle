package com.Models;

public interface Warrior {
    int attack();
    void takeDamage(int damage);
    boolean isAlive();
    void setSquadName(String name);
    String getName();
}
