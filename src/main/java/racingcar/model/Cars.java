package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cars {
    private static final String REGEX = ",";
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String names) {
        List<Car> newCars = Arrays.stream(names.split(REGEX))
                .map(Car::of)
                .toList();
        return new Cars(newCars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
