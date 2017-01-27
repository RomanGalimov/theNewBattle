package com.Controller;


import com.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.LinkedList;

public class Controller {

    public ChoiceBox firstSquadWarriors;
    public ChoiceBox secondSquadWarriors;
    public TextField firstSquadWarriorName;
    public TextField secondSquadWarriorName;
    public TextArea firstSquadList;
    public TextArea secondSquadList;
    public TextField firstSquadName;
    public TextField secondSquadName;
    public TextArea battleLog;
    private LinkedList<Warrior> firstSquad = new LinkedList<>();
    private LinkedList<Warrior> secondSquad = new LinkedList<>();

    @FXML
    private void initialize() {
        for (String name: WarriorCreator.warriorsTypes) {
            firstSquadWarriors.getItems().add(name);
        }
        for (String name: WarriorCreator.warriorsTypes) {
            secondSquadWarriors.getItems().add(name);
        }
    }

    @FXML
    private void addWarrior(ActionEvent event) {
        if(((Button) event.getSource()).getId().equals("firstSquadAddButton")) {
            int warriorType = firstSquadWarriors.getSelectionModel().getSelectedIndex();
            firstSquad.add(WarriorCreator.getWarrior(warriorType, firstSquadWarriorName.getText()));
            firstSquadList.setText(firstSquadList.getText() + firstSquad.getLast().getClass().getSimpleName() + " " + firstSquad.getLast().getName() + "\n");
        } else {
            int warriorType = secondSquadWarriors.getSelectionModel().getSelectedIndex();
            secondSquad.add(WarriorCreator.getWarrior(warriorType, secondSquadWarriorName.getText()));
            secondSquadList.setText(secondSquadList.getText() + secondSquad.getLast().getClass().getSimpleName() + " " + secondSquad.getLast().getName() + "\n");
        }
    }
    @FXML
    private void startBattle(ActionEvent event) {
        if (!firstSquad.isEmpty() || !secondSquad.isEmpty()) {
            Warrior[] squad1arr = new Warrior[firstSquad.size()];
            for (int i = 0; i < squad1arr.length; i++) {
                firstSquad.get(i).setSquadName(firstSquadName.getText());
                squad1arr[i] = firstSquad.get(i);
            }
            Warrior[] squad2arr = new Warrior[secondSquad.size()];
            for (int i = 0; i < squad2arr.length; i++) {
                secondSquad.get(i).setSquadName(secondSquadName.getText());
                squad2arr[i] = secondSquad.get(i);
            }
            Squad squad1 = new Squad(firstSquadName.getText(), squad1arr);
            Squad squad2 = new Squad(secondSquadName.getText(), squad2arr);
            Battle battle = new Battle(squad1, squad2);
            battleLog.setText(battle.getBattleLog());
        } else {
            battleLog.setText("В каждой команде должен быть как минимум один боец.");
        }
    }

    @FXML
    private void clear(ActionEvent event) {
        firstSquadList.setText("");
        secondSquadList.setText("");
        firstSquad = new LinkedList<>();
        secondSquad = new LinkedList<>();
        battleLog.setText("");
    }

}
