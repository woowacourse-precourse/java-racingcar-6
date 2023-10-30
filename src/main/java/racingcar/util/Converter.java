package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.model.Car;

public class Converter {
    private static final String DELIMITER = ",";
    private static final String SINGLE_BLANK = " ";

    public static List<Car> stringToCarList(String input) {
        return Stream.of(input.split(DELIMITER))
                .map(Car::new)
                .toList();
    }

    public static String carListToString(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER+SINGLE_BLANK));
    }
}
