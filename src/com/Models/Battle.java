package com.Models;

public class Battle {

    private DataHelper dataHelper;
    private StringBuilder battleLog;

    public Battle(Squad squad1, Squad squad2) {
        dataHelper = new DataHelper();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dataHelper.getFormattedStartDate() + "\n\n");
        stringBuilder.append(startBattle(squad1, squad2));
        if (squad1.hasAliveWarriors()) {
            stringBuilder.append(("Победил отряд " + squad1.getName()) + "\n\n");
        } else {
            stringBuilder.append(("Победил отряд " + squad2.getName()) + "\n\n");
        }
        stringBuilder.append(dataHelper.getFormattedDiff() + "\n\n");
        this.battleLog = stringBuilder;
    }

    private StringBuilder startBattle(Squad squad1, Squad squad2) {
        StringBuilder stringBuilder = new StringBuilder();
        while (squad1.hasAliveWarriors() && squad2.hasAliveWarriors()) {
            Warrior attackedWarrior = squad2.getRandomWarrior();
            Warrior attackingWarrior = squad1.getRandomWarrior();
            attackedWarrior.takeDamage(attackingWarrior.attack());
            stringBuilder.append(attackingWarrior.toString() + " атаковал и нанес " + attackingWarrior.attack() + " урона " + attackedWarrior + "\n\n");
            if (!attackedWarrior.isAlive()) {
                stringBuilder.append(attackedWarrior.toString() + " погиб" + "\n\n");
            }
            dataHelper.skipTime();
            if (squad2.hasAliveWarriors()) {
                attackedWarrior = squad1.getRandomWarrior();
                attackingWarrior = squad2.getRandomWarrior();
                attackedWarrior.takeDamage(attackingWarrior.attack());
                stringBuilder.append(attackingWarrior.toString() + " атаковал и нанес " + attackingWarrior.attack() + " урона " + attackedWarrior + "\\n");
                if (!attackedWarrior.isAlive()) {
                    stringBuilder.append(attackedWarrior.toString() + " погиб" + "\n\n");
                }
                dataHelper.skipTime();
            }
        }
        return stringBuilder;
    }

    public StringBuilder getBattleLog() {
        return battleLog;
    }

}
