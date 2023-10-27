package racingcar.domain;

import racingcar.exception.CarValidator;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.constant.Separator.REGEX_SEPARATOR;

public class CarFactory {

    private CarFactory() {}

    public static List<Car> generateCarNameList(final String carNames) {
        carNamesValidate(carNames);

        return splitCarNames(carNames).stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static void carNamesValidate(String carNames) {
        CarValidator.validate(carNames);
    }

    private static List<String> splitCarNames(String carNames) {
        return List.of(carNames.split(REGEX_SEPARATOR));
    }
}
