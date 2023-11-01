package racingcar.controller;

import racingcar.model.Car;

import java.util.List;

import static racingcar.view.GameInputView.inputAttemptCount;
import static racingcar.view.GameInputView.inputCarNames;
import static racingcar.view.GameOutputView.displayCurrentCarStatuses;
import static racingcar.view.GameOutputView.printWinnerNames;

public class GameController {

    public void run() {
        List<String> carNames = inputCarNames();
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        int attemptCount = inputAttemptCount();

        System.out.println("실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            cars.forEach(Car::moveForwardRandomly);
            displayCurrentCarStatuses(cars);
        }

        List<String> winnerNames = getWinnerNames(cars);
        printWinnerNames(winnerNames);
    }

    private List<String> getWinnerNames(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }
}
