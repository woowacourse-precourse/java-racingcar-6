package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsGenerator {

    public static List<Car> generateCars(String input) {
        List<String> carNames = List.of(input.split(","));
        return carNames
                .stream()
                .map(Car::of)
                .collect(Collectors.toList());
    }
}
