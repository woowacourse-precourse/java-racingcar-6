package racingcar.domain;

import java.util.stream.Collectors;

public class Winner {
    private Cars cars;
    public Winner( Cars cars) {
        this.cars = cars;
    }

    public String maxLocationCarName() {
        return this.cars.cars.stream()
                .filter(car -> car.location == maxLocation())
                .map(car -> car.carName)
                .collect(Collectors.joining(","));
    }

    public int maxLocation() {
        return this.cars.cars.stream()
                .mapToInt(car -> car.location)
                .max()
                .orElse(-1);
    }
}
