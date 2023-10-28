package racingcar.controller;

import racingcar.model.Race;
import racingcar.view.OutputView;

public class GameController {
    InputController inputController;
    Race race;

    public GameController() {
        setInputController();
        setRace();
        play();
        printResult();
        printWinner();
    }

    public void setInputController(){
        inputController = new InputController();
    }
    public void setRace(){
        race = new Race(inputController.carValidate(), inputController.roundValidate());
    }
    public void play(){
        race.start();
    }
    public void printResult(){
        OutputView.printRace(race.getCarList());
    }
    public void printWinner(){
        OutputView.printWinner(race.getWinner());
    }
}
