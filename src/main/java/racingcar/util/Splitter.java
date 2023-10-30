package racingcar.util;

import java.util.List;
import java.util.stream.Stream;
import racingcar.model.Car;

public class Splitter {
    private static final String DELIMITER = ",";

    public static List<Car> stringToCarList(String input) {
        return Stream.of(input.split(DELIMITER))
                .map(Car::new)
                .toList();
    }
}
