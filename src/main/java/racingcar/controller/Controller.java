package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.service.RacingcarGame;
import racingcar.utils.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    RacingcarGame racingcarGame = new RacingcarGame();

    public void run() {
        OutputView.printInputCarName();
        List<Car> cars = createCarsFromInputCarNames();

        OutputView.printInputAttemptCount();
        Attempt attempt = createAttemptFromInputAttemptCount();
        int attemptCount = attempt.getAttemptCount();

        OutputView.printRaceResult();
        iterateMoveCars(cars, attemptCount);

        List<String> winner = racingcarGame.createWinner(cars);
        OutputView.printWinner(winner);
    }

    private void iterateMoveCars(List<Car> cars, int attemptCount) {
        while (attemptCount > 0) {
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

    private Attempt createAttemptFromInputAttemptCount() {
        Attempt attempt = new Attempt(InputView.inputAttemptCount());
        return attempt;
    }

    private List<Car> createCarsFromInputCarNames() {
        List<Car> cars = InputView.inputCarNames()
                                  .stream()
                                  .map(Car::new)
                                  .collect(Collectors.toList());
        return cars;
    }
}
