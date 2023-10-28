package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.management.ImmutableDescriptor;

public final class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public List<String> getWinner() {
        int maxProgress = cars.stream()
            .mapToInt(Car::getProgress)
            .max()
            .orElse(0);

        return cars.stream()
            .filter(car -> car.getProgress() == maxProgress)
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
