package racingcar.utils;

import static racingcar.constants.MessageConstant.INPUT_SEPARATOR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class Converter {

    public static Cars convertToCars(final String input) {
        return Cars.of(Arrays
                .stream(splitBySeparator(input))
                .toList());
    }

    public static List<Car> convertToCarList(final List<String> names) {
        return names.stream()
                .map(Car::of)
                .collect(Collectors.toList());
    }

    private static String[] splitBySeparator(final String input) {
        return input.split(INPUT_SEPARATOR);
    }
}
