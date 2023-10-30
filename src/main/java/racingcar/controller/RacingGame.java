package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RandomNumberGenerator;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void start() {
        List<String> racingCarNames = InputView.readRacingCarName();
        List<Car> cars = new ArrayList<>();

        Validator.validateIsDuplicate(racingCarNames);
        for (String name : racingCarNames) {
            cars.add(new Car(name, new RandomNumberGenerator()));
        }

        Long tryCount = InputView.readTryCount();

        OutputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            tryToMoveCars(cars);
            OutputView.printResult(cars);
        }

        List<Car> winners = findWinner(cars);

        OutputView.printWinners(winners);

    }

    private void tryToMoveCars(List<Car> cars) {
        for (Car car : cars) {
            car.moveOrStay();
        }
    }

    private List<Car> findWinner(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        Car maxCar = cars.get(0);

        for (Car car : cars) {
            int comparisonResult = car.compareTo(maxCar);
            if (comparisonResult > 0) {
                maxCar = car;
                winners.clear();
                winners.add(car);
            } else if (comparisonResult == 0) {
                winners.add(car);
            }
        }

        return winners;
    }
}