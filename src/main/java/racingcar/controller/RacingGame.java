package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RandomNumberGenerator;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private List<Car> cars;

    public void start() {
        List<String> racingCarNames = InputView.readRacingCarName();
        Long tryCount = InputView.readTryCount();

        cars = createCars(racingCarNames);

        OutputView.printResultMessage();
        printResult(tryCount);

        List<Car> winners = findWinner();
        OutputView.printWinners(winners);
    }

    private List<Car> createCars(List<String> racingCarNames) {
        Validator.validateIsDuplicate(racingCarNames);

        List<Car> cars = new ArrayList<>();
        for (String name : racingCarNames) {
            cars.add(new Car(name, new RandomNumberGenerator()));
        }

        return cars;
    }

    private void printResult(Long tryCount) {
        for (int i = 0; i < tryCount; i++) {
            tryToMoveCars();
            OutputView.printResult(cars);
        }
    }

    private void tryToMoveCars() {
        for (Car car : cars) {
            car.moveOrStay();
        }
    }

    private List<Car> findWinner() {
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