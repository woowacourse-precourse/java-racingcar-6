package racingcar.car;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.game.Constant.COMMA_REGEX_DELIMITER;

public class CarParser {

    private CarParser() {}

    public static List<Car> generateCarList(final String carNames) {
        return splitCarNames(carNames).stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(COMMA_REGEX_DELIMITER));
    }
}
