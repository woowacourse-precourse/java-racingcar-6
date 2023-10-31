package racingcar.controller;

import racingcar.model.RaceGame;
import racingcar.view.InputView;

public class GameController {
    RaceGame raceGame = new RaceGame();
    InputView inputView = new InputView();

    public void startGame() {
        raceGame.setInputCarName(inputView.enterCarName());
        System.out.println(raceGame.getInputCarName());
    }
}
