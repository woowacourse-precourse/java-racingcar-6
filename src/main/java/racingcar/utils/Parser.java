package racingcar.utils;

import static racingcar.global.constants.SymbolType.CAR_NAME_DELIMITER;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class Parser {
    public static List<Car> parseStringToCarList(String userInput) {
        return Arrays.stream(split(userInput))
                .map(name -> Car.of(name))
                .toList();
    }

    private static String[] split(String userInput) {
        return userInput.split(CAR_NAME_DELIMITER.getSymbol());
    }

    public static Integer parseStringToInteger(String userInput) {
        return Integer.parseInt(userInput);
    }
}
