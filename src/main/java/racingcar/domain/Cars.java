package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final CarNames carNames) {
        this.cars = carNames.getCarNames().stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public ForwardDistance getMaxForwardDistance() {
        return Collections.max(cars).getForwardDistance();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }
}
