package racingcar.util;

import static java.util.regex.Pattern.matches;

import java.util.List;
import racingcar.exception.console_input.CanNotConvertToIntInputException;

public class Converter {

    private static final String COMMA = ",";
    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    private Converter() {
    }

    public static List<String> splitWithComma(final String string) {
        String[] splitString = string.split(COMMA);
        return List.of(splitString);
    }

    public static int stringToInt(final String string) {
        validateStringToInt(string);
        return Integer.parseInt(string);
    }

    private static void validateStringToInt(final String string) {
        if (!matches(REGEXP_PATTERN_NUMBER, string)) {
            throw new CanNotConvertToIntInputException(string);
        }
    }
}
