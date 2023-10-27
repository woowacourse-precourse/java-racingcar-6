package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String names) {
        List<Name> carNames = Name.createCarNames(names);
        List<Car> cars = carNames.stream()
                .map(Car::from)
                .toList();

        return new Cars(cars);
    }
}
