package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarNames {

    private List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public List<Car> assignNamesToCars() {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return cars;
    }
}
