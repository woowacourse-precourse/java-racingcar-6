package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class RacingCars {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int MIN_NUMBER = 4;
    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;

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
        return MIN_NUMBER <= makeRandomNumber();
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
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
