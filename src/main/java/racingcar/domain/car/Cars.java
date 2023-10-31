package racingcar.domain.car;

import static racingcar.domain.car.NameConstants.NAME_DUPLICATED;

import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    private final Decider decider;
    private static final String NEED_MORE_NAMES_MESSAGE = "두 개 이상의 이름을 입력하세요.";
    private Cars(List<Car> cars, Decider decider) {
        validateSize(cars);
        validateNotDuplicated(cars);
        this.cars = cars;
        this.decider = decider;
    }

    private void validateSize(List<Car> cars) {
        if (cars.size() <= 1) {
            throw new IllegalArgumentException(NEED_MORE_NAMES_MESSAGE);
        }
    }

    public static Cars of(List<Car> input, Decider decider) {
        return new Cars(input, decider);
    }

    private void validateNotDuplicated(List<Car> input) {
        if (isDuplicated(input)) {
            throw new IllegalArgumentException(NAME_DUPLICATED);
        }
    }

    private boolean isDuplicated(List<Car> input) {
        return input.size() != input.stream()
                .distinct()
                .count();
    }

    public void moveCars() {
        cars.stream()
                .filter(car -> decider.isSucceed())
                .forEach(Car::go);
    }

    public List<String> getResults() {
        return cars.stream()
                .map(Car::getResult)
                .toList();
    }

    public List<String> findWinnerNames() {
        Car maxCar = Collections.max(cars);
        return cars.stream()
                .filter(car -> isSameDistance(car, maxCar))
                .map(Car::getNameValue)
                .toList();
    }

    private static boolean isSameDistance(Car car, Car maxCar) {
        return maxCar.compareTo(car) == 0;
    }
}
