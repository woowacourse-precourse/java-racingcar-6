package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    private static final String DELIMITER = ",";

    public static List<String> parseToList(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }
}
