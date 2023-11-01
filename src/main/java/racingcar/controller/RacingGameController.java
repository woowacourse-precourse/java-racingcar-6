package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.round.GameRound;
import racingcar.utils.RandomNumber;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private Cars cars;
    private GameRound gameRound;
    private final RandomNumber randomNumber = new RandomNumberGenerator();

    public void run() {
        initCarNames();
        initGameRound();

        printGameResultMessage();
        printGameContinuable();
        printGameWinner();
    }

    private void printGameResultMessage() {
        OutputView.printGameResultMessage();
    }

    private void printGameContinuable() {
        while (gameRound.isContinuable()) {
            playGame();
            OutputView.printCarStatuses(cars.getCarStatus());
        }
    }

    private void playGame() {
        cars.checkCarIsMovable();
        gameRound.isCountDecrease();
    }

    private void printGameWinner() {
        final List<String> winnerNames = cars.getGameWinner();
        OutputView.printGameWinnerMessage(winnerNames);
    }

    private void initCarNames() {
        cars = new Cars(InputView.readCarName(), randomNumber);
    }

    private void initGameRound() {
        gameRound = new GameRound(InputView.readGameRound());
    }
}
