package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final Car car;
    private final RacingGame racingGame;
    private final OutputView outputView;

    public GameController(InputView inputView, Car car, RacingGame racingGame, OutputView outputView) {
        this.inputView = inputView;
        this.car = car;
        this.racingGame = racingGame;
        this.outputView = outputView;
    }

    public void play() {
        inputView.startGame();
        List<String> carList = car.extractCarList(inputView.registerCars());
        inputView.registerCount();
        List<String> winnerList = racingGame.playRacingGame(carList, inputView.registerAttempt());
        outputView.showWinners(winnerList);
    }
}
