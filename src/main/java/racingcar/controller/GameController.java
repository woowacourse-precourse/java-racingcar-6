package racingcar.controller;

import domain.fisrtCollection.Cars;
import domain.strategy.CarMovingStrategy;
import domain.strategy.MoveStrategy;
import domain.valueObject.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final MoveStrategy movableStrategy = new CarMovingStrategy();
    private static final int ZERO = 0;

    public void start() {
        final Cars cars = setupCars();
        race(cars, InputView.getRound());
        OutputView.printWinner(cars.getWinnerName());
    }

    private Cars setupCars() {
        return new Cars(getCarsFromInput());
    }

    private List<Car> getCarsFromInput() {
        return getCarByCarName(getCarName());
    }

    private List<String> getCarName() {
        String input = InputView.getCarName();
        String[] splitName = input.split(CAR_NAME_DELIMITER);

        for (int i = ZERO; i < splitName.length; i++) {
            splitName[i] = splitName[i].trim();
        }

        return Arrays.stream(splitName).collect(Collectors.toList());
    }

    private List<Car> getCarByCarName(final List<String> carName) {
        return carName.stream().map(Car::new).collect(Collectors.toList());
    }

    private void race(final Cars cars, final int rounds) {
        for (int round = ZERO; round < rounds; round++) {
            cars.move(movableStrategy);
            OutputView.printCurrentPosition(cars.getCars());
        }
    }
}
