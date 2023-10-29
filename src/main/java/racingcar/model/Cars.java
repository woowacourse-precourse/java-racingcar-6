package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
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
}
