package racingcar.domain;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void attemptToMoveAll() {
        for (Car car : cars) {
            car.attemptToMove();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> getCarPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
