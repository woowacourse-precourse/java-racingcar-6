package racingcar.car;

import java.util.List;
import java.util.stream.Collectors;
import static racingcar.game.Delimiter.REGEX_DELIMITER;

public class CarFactory {

    private CarFactory() {}

    public static List<Car> generateCarList(final String carNames) {
        return splitCarNames(carNames).stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(REGEX_DELIMITER));
    }
}
