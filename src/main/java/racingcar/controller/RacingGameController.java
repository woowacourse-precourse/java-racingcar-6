package racingcar.controller;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.round.GameRound;
import racingcar.utils.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final Cars cars;
    private final GameRound gameRound;
    private final RandomNumber randomNumber;

    public RacingGameController(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
        this.cars = initCarNames();
        this.gameRound = initGameRound();
    }

    public void run() {
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

    private Cars initCarNames() {
        return new Cars(InputView.readCarName(), randomNumber);
    }

    private GameRound initGameRound() {
        return new GameRound(InputView.readGameRound());
    }
}
