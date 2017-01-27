package com.Models;

public class Battle {

    private DateHelper dateHelper;
    private StringBuilder battleLog;

    public Battle(Squad squad1, Squad squad2) {
        dateHelper = new DateHelper();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(dateHelper.getFormattedStartDate());
        stringBuilder.append("\n\n");
        stringBuilder.append(startBattle(squad1, squad2));
        if (squad1.hasAliveWarriors()) {
            stringBuilder.append("Победил отряд ");
            stringBuilder.append(squad1.getName());
            stringBuilder.append("\n\n");
        } else {
            stringBuilder.append("Победил отряд ");
            stringBuilder.append(squad2.getName());
            stringBuilder.append("\n\n");
        }
        stringBuilder.append(dateHelper.getFormattedDiff());
        stringBuilder.append("\n\n");
        this.battleLog = stringBuilder;
    }

    private StringBuilder startBattle(Squad squad1, Squad squad2) {
        StringBuilder stringBuilder = new StringBuilder();
        while (squad1.hasAliveWarriors() && squad2.hasAliveWarriors()) {
            Warrior attackedWarrior = squad2.getRandomWarrior();
            Warrior attackingWarrior = squad1.getRandomWarrior();
            attackedWarrior.takeDamage(attackingWarrior.attack());
            messageWriter(stringBuilder, attackedWarrior, attackingWarrior);
            dateHelper.skipTime();
            if (squad2.hasAliveWarriors()) {
                attackedWarrior = squad1.getRandomWarrior();
                attackingWarrior = squad2.getRandomWarrior();
                attackedWarrior.takeDamage(attackingWarrior.attack());
                messageWriter(stringBuilder, attackedWarrior, attackingWarrior);
                dateHelper.skipTime();
            }
        }
        return stringBuilder;
    }

    public String getBattleLog() {
        return battleLog.toString();
    }

    public void messageWriter(StringBuilder stringBuilder, Warrior attackedWarrior, Warrior attackingWarrior) {
        stringBuilder.append(attackingWarrior.toString());
        stringBuilder.append(" атаковал и нанес ");
        stringBuilder.append(attackingWarrior.attack());
        stringBuilder.append(" урона ");
        stringBuilder.append(attackedWarrior);
        stringBuilder.append("\n\n");
        if (!attackedWarrior.isAlive()) {
            stringBuilder.append(attackedWarrior.toString());
            stringBuilder.append(" погиб");
            stringBuilder.append("\n\n");
        }
    }

}
