package racingcar.game;

import racingcar.game.controller.GameController;

public class RacingCarGame {
    private GameController controller;

    public RacingCarGame() {
        controller = new GameController();
    }

    public void play() {
        controller.initializeCars();
        controller.initializeRaceCount();
        controller.race();
        controller.showWinners();
    }
}
