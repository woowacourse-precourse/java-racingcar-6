package racingcar.domain;

import static racingcar.util.NameValidator.validateNameLengthBelowFive;

import java.util.List;
import java.util.stream.Collectors;

public class CarManufacturer {
    public List<Car> createCars(List<String> carNames) {
        validateNameLengthBelowFive(carNames);
        return carNames
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
