package racingcar.controller;

import racingcar.handler.InputHandler;
import racingcar.view.GameView;

import java.util.List;

public class GameController {
    private final GameView gameView;
    private final InputHandler inputHandler;

    public GameController(GameView gameView, InputHandler inputHandler) {
        this.gameView = gameView;
        this.inputHandler = inputHandler;
    }

    public void startGame() {
        String carNames = gameView.inputCarNames();

    }
}
