package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> value;
    private Cars(List<Car> values) {
        this.value = values;
    }

    public static Cars of(List<String> values) {
        return new Cars(values.stream()
                .map(value -> Car.of(value))
                .collect(Collectors.toList()));
    }
}
