package racingcar.util;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.Constant.COMMA_REGEX_DELIMITER;

public class CarListGenerator {

    private CarListGenerator() {}

    public static List<Car> generateCarList(final String carNames) {
        return splitCarNames(carNames).stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static List<String> splitCarNames(final String carNames) {
        return List.of(carNames.split(COMMA_REGEX_DELIMITER));
    }
}