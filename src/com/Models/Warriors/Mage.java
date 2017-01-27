package com.Models.Warriors;

import com.Models.AbstractWarrior;

public class Mage extends AbstractWarrior implements Cloneable {
    private int health;
    private int damage;
    private String name;
    private String squadName;

    public Mage(String name) {
        super(name, 80, 70);
    }

}
