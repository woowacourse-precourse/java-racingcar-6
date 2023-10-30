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
    private Long tryCount;

    public void start() {
        cars = createCars(InputView.readRacingCarName());
        tryCount = InputView.readTryCount();

        OutputView.printResultMessage();
        printResult();

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

    private void printResult() {
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