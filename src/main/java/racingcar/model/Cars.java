package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(String[] carNames) {
        cars = Arrays.stream(carNames)
                .map((name) -> new Car(name))
                .collect(Collectors.toUnmodifiableList());
    }

    public static Cars makeCarsByNames(String[] carNames) {
        return new Cars(carNames);
    }

}
