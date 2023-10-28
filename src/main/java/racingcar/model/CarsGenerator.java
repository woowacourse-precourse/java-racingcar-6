package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class CarsGenerator {

    public List<Car> generate(String carNames) {
        return splitCarNames(carNames).stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(","));
    }

}
