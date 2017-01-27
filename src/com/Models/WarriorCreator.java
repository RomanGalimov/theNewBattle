package com.Models;

import com.Models.Warriors.Archer;
import com.Models.Warriors.Barbarian;
import com.Models.Warriors.Headhunter;
import com.Models.Warriors.Mage;

/**
 * Created by GetAnUco on 16.01.2017.
 */
public class WarriorCreator {
    public static String[] warriorsTypes = {"Archer", "Barbarian", "Mage", "Headhunter"};

    public static Warrior getWarrior(int num, String name) {
        switch (num) {
            case 0:
                return getArcher(name);
            case 1:
                return getBarbarian(name);
            case 2:
                return getMage(name);
            case 3:
                return getHeadhunter(name);
            default:
                return null;
        }
    }

    public static Archer getArcher(String name) {
        return new Archer(name);
    }
    public static Barbarian getBarbarian(String name) {
        return new Barbarian(name);
    }
    public static Mage getMage(String name) {
        return new Mage(name);
    }
    public static Headhunter getHeadhunter(String name) {
        return new Headhunter(name);
    }

}
