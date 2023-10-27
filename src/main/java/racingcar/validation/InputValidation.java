package racingcar.validation;

import java.util.List;
import racingcar.constants.ExceptionMessage;
import racingcar.util.InputParser;

public class InputValidation {
    public static List<String> validateCars(String input) {
        isExistCars(input);
        return InputParser.carsParser(input);
    }

    private static void isExistCars(String input) {
        if (input.isEmpty()) {
            ExceptionMessage.NONE_INPUT_CARS.throwException();
        }
    }
}
