package racingcar.model;

import static racingcar.message.ExceptionMessage.DUPLICATE_NAME;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateDuplication(cars);
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    private void validateDuplication(List<Car> cars) {
        Set<Car> carSet = Set.copyOf(cars);
        if (cars.size() != carSet.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME.getMessage());
        }
    }

    public int size() {
        return cars.size();
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Cars other
                && cars.equals(other.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
