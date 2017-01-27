package com.Models.Warriors; //заглавные буквы в наименовании пакетов как правило не используют

import com.Models.AbstractWarrior;

public class Archer extends AbstractWarrior implements Cloneable  {
    private int health; //эти поля не нужны
    private int damage;
    private String name;
    private String squadName;

    public Archer(String name) {
        super(name, 100, 50);
    }
}
