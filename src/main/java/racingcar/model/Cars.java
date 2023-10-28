package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public final class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> names) {
        List<Car> carList = names.stream()
            .map(Car::from)
            .collect(Collectors.toList());
        return new Cars(carList);
    }

}
