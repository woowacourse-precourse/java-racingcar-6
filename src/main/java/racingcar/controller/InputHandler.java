package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.validator.InputValidator;

public class InputHandler {

    public static List<String> parseCarName(String input) {
        List<String> carNames = new ArrayList<>();
        InputValidator.validateName(input);
        splitInput(carNames, input);

        return carNames;
    }

    public static int triesCount(String input) {
        int tries = 0;
        InputValidator.validateNumber(input);
        tries = Integer.parseInt(input);
        return tries;
    }

    private static void splitInput(List<String> carNames, String input) {
        Arrays.stream(input.split(","))
            .map(String::trim)
            .forEach(carNames::add);
    }
}
