package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {
    private static final String COMMA = ",";

    private CarGenerator() {
    }

    public static List<Car> generateParticipationCarList(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }
}
