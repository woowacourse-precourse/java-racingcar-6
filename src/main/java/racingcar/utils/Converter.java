package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import racingcar.constants.ErrorMessage;

public class Converter {
    public static List<String> convertStringToList (String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    public static int convertStringToInt (String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NAME_MUST_BE_NUMBER.getMessage());
        }
    }
}
