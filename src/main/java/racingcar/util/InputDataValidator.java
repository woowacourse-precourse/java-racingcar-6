package racingcar.util;

import java.util.List;
import racingcar.common.Config;

public class InputDataValidator {

    public static void validateInputSize(List<String> inputList) throws IllegalArgumentException {

        for (String input : inputList) {
            validateEachInputSize(input);
        }

    }

    private static void validateEachInputSize(String input) throws IllegalArgumentException {

        if (input.length() > Config.MAX_NAME_SIZE) {
            throw new IllegalArgumentException();
        }

    }

    public static void validateHasSpace(String input) throws IllegalArgumentException {

        if (input.contains(" ")) {
            throw new IllegalArgumentException();
        }

    }

    public static void validateIsInteger(String input) throws IllegalArgumentException {

        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }

    }
}
