package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public String statusMessage() {
        return cars.stream()
                .map(Car::forwardStatus)
                .collect(Collectors.joining("\n"));
    }

}
