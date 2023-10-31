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
        List<Car> cars = addCarToList();

        OutputView.printInputAttemptCount();
        Attempt attempt = createAttempt();
        int attemptCount = attempt.getAttemptCount();

        OutputView.printResult();
        result(cars, attemptCount);

        List<String> winner = racingcarGame.createWinner(cars);
        OutputView.printWinner(winner);
    }

    private void result(List<Car> cars, int attemptCount) {
        while (attemptCount > 0) {
            for (Car car : cars) {
                int random = Utils.generateRandomNumber();
                racingcarGame.increaseMoveForwardCount(car, random);
                OutputView.printMoveForward(car);
            }
            attemptCount--;
            System.out.println();
        }
    }

    private Attempt createAttempt() {
        Attempt attempt = new Attempt(InputView.inputAttemptCount());
        return attempt;
    }

    private List<Car> addCarToList() {
        List<Car> cars = InputView.inputCarName()
                                  .stream()
                                  .map(Car::new)
                                  .collect(Collectors.toList());
        return cars;
    }
}
