package racingcar.domain.car;

import static racingcar.domain.car.NameConstants.NAME_DUPLICATED;

import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    private final Decider decider;

    private Cars(List<Car> cars, Decider decider) {
        validate(cars);
        this.cars = cars;
        this.decider = decider;
    }

    public static Cars of(List<Car> input, Decider decider) {
        return new Cars(input, decider);
    }

    private void validate(List<Car> input) {
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
                .filter(car -> maxCar.compareTo(car) == 0)
                .map(Car::getNameValue)
                .toList();
    }
}
