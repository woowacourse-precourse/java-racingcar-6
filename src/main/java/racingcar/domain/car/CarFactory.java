package racingcar.domain.car;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.Delimiter.REGEX_DELIMITER;

public class CarFactory {

    private CarFactory() {}

    public static List<Car> generateCarNameList(final String carNames) {
        return splitCarNames(carNames).stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(REGEX_DELIMITER));
    }
}
