package racingcar.model;

import java.util.List;
import java.util.Objects;

public class CarManager {

    private final List<Car> cars;

    public CarManager(final List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarManager that = (CarManager) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        return "CarManager{" +
                "cars=" + cars +
                '}';
    }
}
