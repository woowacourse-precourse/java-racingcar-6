package racingcar.domain;

import static racingcar.enums.ExceptionMessage.EXCEED_MAX_LENGTH_MESSAGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateNameLength(cars);
        this.cars = new ArrayList<>(cars);
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCar() {
        return Collections.unmodifiableList(cars);
    }

    private void validateNameLength(List<Car> cars) {
        for (Car car : cars) {
            if (car.isExceedMaxLength()) {
                throw new IllegalArgumentException(EXCEED_MAX_LENGTH_MESSAGE.getMessage());
            }
        }
    }

}
