package com.Models;

/**
 * Created by GetAnUco on 22.01.2017.
 */
public interface Warrior {

    public String getName();

    public int attack();

    public void takeDamage(int damage);

    public boolean isAlive();

    public void setSquadName(String name);

    public int getHealth();

    public Warrior clone();

}
