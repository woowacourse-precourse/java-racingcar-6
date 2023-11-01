package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

    private final List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public List<Car> assignNamesToCars() {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
