package racingcar.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record Cars(List<Car> names) {

    public Cars(String input) {
        this(Arrays.stream(input.split(","))
                .map(Car::new)
                .collect(Collectors.toList()));

    }

    private static final int MAX_ALLOWED_COUNT = 5;

    public String formatNames() {
        return this.names.stream().map(Car::name).collect(Collectors.joining(","));
    }
}



