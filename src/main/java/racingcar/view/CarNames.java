package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record CarNames(List<CarName> names) {

    public CarNames(String input) {
        this(Arrays.stream(input.split(","))
                .map(CarName::new)
                .collect(Collectors.toList()));

    }

    private static final int MAX_ALLOWED_COUNT = 5;

    public String formatNames() {
        return this.names.stream().map(CarName::name).collect(Collectors.joining(","));
    }
}



