package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.service.RacingcarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    RacingcarGame racingcarGame = new RacingcarGame();

    public void run() {
        List<Car> cars = addCarToList();
        Attempt attempt = createAttempt();
        OutputView.printResult();
        int attemptCount = attempt.getAttemptCount();
        result(cars, attemptCount);
    }

    public void result(List<Car> cars, int attemptCount) {
        while (attemptCount > 0) {
            for (Car car : cars) {
                racingcarGame.increaseMoveForwardCount(car);
                OutputView.printMoveForward(car);
            }
            attemptCount--;
            System.out.println();
        }
    }

    public Attempt createAttempt() {
        Attempt attempt = new Attempt(InputView.inputAttemptCount());
        return attempt;
    }

    public List<Car> addCarToList() {
        List<Car> cars = InputView.inputCarName()
                                  .stream()
                                  .map(Car::new)
                                  .collect(Collectors.toList());
        return cars;
    }
}
