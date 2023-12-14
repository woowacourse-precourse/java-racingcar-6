package racingcar.domain;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> cars) {
        this.cars = generateToCars(cars);
    }

    private List<Car> generateToCars(List<String> cars) {
        return cars.stream()
                .map(name -> new Car(new Name(name)))
                .toList();
    }
}
