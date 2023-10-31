package racingcar.controller;

import racingcar.model.Game;
import racingcar.view.Input;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameController {
    private Game game;

    public GameController() {
    }

    public void getUserInput() {
        String carNames = Input.carNameInput();
        int numberOfAttempts = Input.attemptInput();
        game = new Game(carNames, numberOfAttempts);
    }

    public void startGame() {
        game.startGame();
        game.printWinners();
    }
}
