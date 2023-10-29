package racingcar.domain;

import static racingcar.enums.ExceptionMessage.DUPLICATE_NAME_MESSAGE;
import static racingcar.enums.ExceptionMessage.EXCEED_MAX_LENGTH_MESSAGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateNameLength(cars);
        validateDuplicateNumber(cars);
        this.cars = new ArrayList<>(cars);
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCar() {
        return Collections.unmodifiableList(cars);
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public void sortingCarsOrderByPosition() {
        Collections.sort(cars);
    }

    private void validateNameLength(final List<Car> cars) {
        for (Car car : cars) {
            if (car.isExceedMaxLength()) {
                throw new IllegalArgumentException(EXCEED_MAX_LENGTH_MESSAGE.getMessage());
            }
        }
    }

    private void validateDuplicateNumber(final List<Car> cars) {
        if (hasDuplicateElements(cars)) {
            throw new IllegalArgumentException(DUPLICATE_NAME_MESSAGE.getMessage());
        }
    }

    private boolean hasDuplicateElements(final List<Car> cars) {
        if (new HashSet<>(cars).size() != cars.size()) {
            return true;
        }
        return false;
    }

}
