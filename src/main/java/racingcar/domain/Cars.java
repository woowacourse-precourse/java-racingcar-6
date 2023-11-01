package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.ExceptionMessage;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars create(List<Car> cars) {
        validateDuplicateCarName(cars);
        return new Cars(cars);
    }

    private static void validateDuplicateCarName(List<Car> cars) {
        if (cars.size() != cars.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_DUPLICATE);
        }
    }

    public void move() {
        cars.forEach(Car::tryMove);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
