package com.Models.Warriors;

import com.Models.AbstractWarrior;

public class Archer extends AbstractWarrior implements Cloneable  {
    private int health;
    private int damage;
    private String name;
    private String squadName;

    public Archer(String name) {
        super(name, 100, 50);
    }
}
