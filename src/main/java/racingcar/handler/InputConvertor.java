package racingcar.handler;

import java.util.Arrays;
import java.util.List;

public class InputConvertor {
    static final String COMMA_DELIMITER = ",";

    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(COMMA_DELIMITER))
            .toList();
    }

    public static int convertToInt(String input) {
        return Integer.parseInt(input);
    }
}
