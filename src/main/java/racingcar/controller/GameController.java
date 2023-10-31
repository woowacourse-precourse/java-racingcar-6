package racingcar.controller;

import racingcar.model.RacingCars;
import racingcar.view.OutputView;

public class GameController {

    private RacingCars cars;
    private int numberOfRounds;

    public GameController() {
        initializeGame();
        playGame();
        showWinners();
    }

    private void initializeGame() {
        cars = InputController.setupRacingCars();
        numberOfRounds = InputController.getNumberOfRounds();
    }

    private void playGame() {
        OutputView.printGameStartMessage();
        for (int round = 0; round < numberOfRounds; round++) {
            cars.playRound();
        }
    }

    private void showWinners() {
        cars.showWinners();
    }
}
