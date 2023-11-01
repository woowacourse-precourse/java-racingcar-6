package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final Car car;
    private final RacingGame racingGame;

    public GameController(InputView inputView, Car car, RacingGame racingGame) {
        this.inputView = inputView;
        this.car = car;
        this.racingGame = racingGame;
    }

    public void play() {
        inputView.startGame();
        List<String> carList = car.extractCarList(inputView.registerCars());
        inputView.registerCount();
        racingGame.playRacingGame(carList, inputView.registerAttempt());
    }
}
