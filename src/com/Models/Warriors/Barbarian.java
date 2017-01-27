package com.Models.Warriors;

import com.Models.AbstractWarrior;

public class Barbarian extends AbstractWarrior implements Cloneable {
    private int health;
    private int damage;
    private String name;
    private String squadName;


    public Barbarian(String name) {
        super(name, 120, 30);
    }


}
