package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {
    private final List<Car> cars;

    public RacingCar(List<String> names) {
        this.cars = names.stream()
                .map(n -> new Car(n, 0))
                .collect(Collectors.toList());
    }


}
