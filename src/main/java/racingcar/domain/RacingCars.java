package racingcar.domain;

import racingcar.utils.NumberMaker;

import java.util.Arrays;
import java.util.List;

public class RacingCars {

    private static final String CAR_NAME_DELIMITER = ",";

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
            car.move(NumberMaker.makeRandomNumber());
        }
        return cars;
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
