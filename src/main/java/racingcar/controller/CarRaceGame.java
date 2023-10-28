package racingcar.controller;

import racingcar.view.CarRaceGameView;

public class CarRaceGame {
    private static CarRaceGameView carRaceGameView = CarRaceGameView.getCarRaceGameView();

    public CarRaceGame() {}

    public void run() {
        carRaceGameView.startGameView();
        startGame();
    }

    public void startGame() {

    }
}
