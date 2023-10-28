package racingcar.controller;

import racingcar.model.Race;
import racingcar.view.OutputView;

public class GameController {
    InputController inputController;
    Race race;

    public GameController() {
        inputController = new InputController();;
        race = new Race(inputController.carValidate(), inputController.roundValidate());
        play();
        printResult();
    }

    public void play(){
        race.start();
    }

    public void printResult(){
        OutputView.printRace(race.getCarList());
    }
}
