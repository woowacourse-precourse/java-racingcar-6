package racingcar.controller;

import racingcar.model.Race;

public class GameController {
    InputController inputController;
    Race race;

    public GameController() {
        this.inputController = new InputController();
        this.race = new Race(inputController.carValidate(), inputController.roundValidate());
        play();
    }

    public void play(){
        race.start();
    }
}
