package racingcar.controller;

import racingcar.handler.InputHandler;
import racingcar.service.CarService;
import racingcar.view.GameView;

import java.util.List;

public class GameController {
    private final GameView gameView;
    private final InputHandler inputHandler;
    private final CarService carService;

    public GameController(GameView gameView, InputHandler inputHandler, CarService carService) {
        this.gameView = gameView;
        this.inputHandler = inputHandler;
        this.carService = carService;
    }

    public void startGame() {
        String carNames = gameView.inputCarNames();

    }
}
