package racingcar.domain;

import racingcar.utils.NumberMaker;

import java.util.Arrays;
import java.util.List;

public class RacingCars {

    private static final int MIN_SIZE = 2;
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String CARS_SIZE_EXCEPTION = "최소 %d대 이상의 자동차가 있어야 합니다.";

    private final List<Car> cars;

    private RacingCars(List<Car> cars) {
        validateSize(cars);
        this.cars = cars;
    }

    public static RacingCars from(String carNames) {
        List<Car> cars = Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .map(Car::new)
                .toList();
        return new RacingCars(cars);
    }

    private void validateSize(List<Car> cars) {
        if (cars.size() < MIN_SIZE) {
            throw new IllegalArgumentException(String.format(CARS_SIZE_EXCEPTION, MIN_SIZE));
        }
    }

    public List<Car> race() {
        for (Car car : cars) {
            car.move(NumberMaker.makeRandomNumber());
        }
        return cars;
    }

    public List<Car> findWinners() {
        int maxMove = getMaxMove();
        return cars.stream()
                .filter(car -> car.isMaxMove(maxMove))
                .toList();
    }

    private int getMaxMove() {
        return cars.stream()
                .map(Car::getMoveCount)
                .mapToInt(num -> num)
                .max()
                .orElseThrow();
    }
}
