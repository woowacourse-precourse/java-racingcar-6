package racingcar.utils;

import static racingcar.global.constants.SymbolType.CAR_NAME_DELIMITER;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public final class Parser {
    public static List<Car> parseStringToCarList(final String userInput) {
        return Arrays.stream(split(userInput))
                .map(name -> Car.of(name))
                .toList();
    }

    public static Integer parseStringToInteger(final String userInput) {
        return Integer.parseInt(userInput);
    }

    private static String[] split(final String userInput) {
        return userInput.split(CAR_NAME_DELIMITER.getSymbol());
    }
}
