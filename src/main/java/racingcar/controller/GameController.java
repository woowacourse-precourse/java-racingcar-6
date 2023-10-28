package racingcar.controller;

import racingcar.model.Race;
import racingcar.view.OutputView;

public class GameController {
    InputController inputController = new InputController();;
    Race race;

    public GameController() {
        this.race = new Race(inputController.carValidate(), inputController.roundValidate());
        play();
        printResult();
    }

    public void play(){
        race.start();
    }

    public void printResult(){
        race.printRace();
    }
}
