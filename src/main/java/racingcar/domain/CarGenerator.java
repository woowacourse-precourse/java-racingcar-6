package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {

    private CarGenerator() {
    }

    public static List<Car> generateParticipationCarList(String input) {
        return Arrays.stream(input.split(","))
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }
}
