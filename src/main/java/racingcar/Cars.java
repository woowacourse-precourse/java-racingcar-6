package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> move() {
        for (Car car : cars) {
            car.startEngine();
        }
        return getReadOnlyCarList();
    }

    private List<Car> getReadOnlyCarList() {
        return cars.stream()
                .map(car -> new Car(car.getName(), car.getCarEngine(), new Position(car.getPosition())))
                .collect(Collectors.toUnmodifiableList());
    }
}
