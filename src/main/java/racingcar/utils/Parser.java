package racingcar.utils;

import java.util.List;

public class Parser {
    private static final String COMMA = ",";

    public static Integer parseInteger(String input) {
        return Integer.parseInt(input);
    }

    public static List<String> parseStrings(String input) {
        return List.of(input.split(COMMA));
    }
}
