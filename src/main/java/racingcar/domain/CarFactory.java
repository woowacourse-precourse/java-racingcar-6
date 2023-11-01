package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class CarFactory {
    private final static String DELIMITER = ",";

    public static List<Car> makeCars(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER))
                .map(Car::new).toList();
    }
}
