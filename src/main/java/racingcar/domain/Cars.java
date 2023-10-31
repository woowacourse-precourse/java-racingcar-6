package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<String> racingCarNames) {
        this.cars = racingCarNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Integer getMaxForwardDistance() {
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
