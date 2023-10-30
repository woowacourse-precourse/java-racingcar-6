package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }


    public List<Car> tryToMove() {
        for (Car car : cars) {
            car.triesToMove();
        }
        return getCurrentStatus();
    }

    public List<Car> getCurrentStatus() {
        return Collections.unmodifiableList(cars);
    }
}
