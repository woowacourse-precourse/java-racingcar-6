package racingcar.controller;

import java.util.List;
import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.service.RacingcarGame;
import racingcar.utils.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private static final int STOP_MOVE_FORWARD = 0;
    private final RacingcarGame racingcarGame = new RacingcarGame();
    private List<Car> cars;
    private int attemptCount;

    public void run() {
        startGame();
        playGame();
        showWinners();
    }

    private void showWinners() {
        List<String> winners = racingcarGame.createWinners(cars);
        OutputView.printWinner(winners);
    }

    private void playGame() {
        OutputView.printRaceResult();
        while (attemptCount > STOP_MOVE_FORWARD) {
            moveCars(cars);
            attemptCount--;
            System.out.println();
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = Utils.generateRandomNumber();
            racingcarGame.increaseMoveForwardCount(car, randomNumber);
            OutputView.printMoveForward(car);
        }
    }

    private void startGame() {
        setupCarsFromInputCarNames();
        setupAttemptCountFromInputAttemptCount();
    }

    private void setupAttemptCountFromInputAttemptCount() {
        OutputView.printInputAttemptCount();
        Attempt attempt = new Attempt(InputView.inputAttemptCount());
        attemptCount = attempt.getAttemptCount();
    }

    private void setupCarsFromInputCarNames() {
        OutputView.printInputCarNames();
        cars = InputView.inputCarNames()
                        .stream()
                        .map(Car::new)
                        .toList();
    }
}
