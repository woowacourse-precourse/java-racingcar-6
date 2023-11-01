package racingcar.controller;

import racingcar.model.Game;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingGame {
    private Game game;

    public RacingGame() {
    }

    public void startGame() {
        ready();
        game.start();
        game.printWinners();
    }

    public void ready() {
        Output.nameInputMessage();
        String carNames = Input.carNameInput();
        Output.attemptInputMessage();
        int numberOfAttempts = Input.attemptInput();
        game = new Game(carNames, numberOfAttempts);
    }
}
