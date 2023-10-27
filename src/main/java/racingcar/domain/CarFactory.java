package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {
    private static final String COMMA = ",";

    private CarFactory() {
    }

    public static List<Car> generateParticipationCarList(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }
}
