package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarsGenerator {

    private static CarsGenerator carsGenerator;

    private CarsGenerator() {
    }

    public List<Car> generateCars(String input) {
        List<String> carNames = List.of(input.split(","));
        return carNames
                .stream()
                .map(Car::of)
                .collect(Collectors.toList());
    }

    public static CarsGenerator getInstance() {
        if (carsGenerator == null) {
            carsGenerator = new CarsGenerator();
        }
        return carsGenerator;
    }
}
