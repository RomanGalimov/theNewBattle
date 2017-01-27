package com.Models.Warriors;

import com.Models.AbstractWarrior;

/**
 * Created by GetAnUco on 16.01.2017.
 */
public class Headhunter extends AbstractWarrior implements Cloneable {
    private int health;
    private int damage;
    private String name;
    private String squadName;

    public Headhunter(String name) {
        super(name, 110, 100);
    }

}
