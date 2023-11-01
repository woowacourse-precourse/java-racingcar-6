package racingcar.util;

import racingcar.validation.CarNameInputValidator;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {

    public static List<String> parse(String input) {
        CarNameInputValidator.validateInput(input);
        return Arrays.asList(input.split(","));
    }
}