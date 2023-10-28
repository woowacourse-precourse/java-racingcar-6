package racingcar.domain;

import racingcar.utils.NumberMaker;

import java.util.Arrays;
import java.util.List;

public class RacingCars {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MIN_NUMBER = 4;

    private final List<Car> cars;

    private RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCars from(String carNames) {
        List<Car> cars = Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .toList();
        return new RacingCars(cars);
    }

    public List<Car> race() {
        for (Car car : cars) {
            if (canMove()) {
                car.move();
            }
        }
        return cars;
    }

    private boolean canMove() {
        return MIN_NUMBER <= NumberMaker.makeRandomNumber();
    }

    public List<Car> findWinners() {
        int maxMove = cars.stream()
                .map(Car::getMoveCount)
                .mapToInt(num -> num)
                .max()
                .orElseThrow();

        return cars.stream()
                .filter(car -> car.isMaxMove(maxMove))
                .toList();
    }
}
