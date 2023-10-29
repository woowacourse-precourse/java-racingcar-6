package racingcar.utils;

import java.util.List;

public class Parser {
    public static final String COMMA = ",";
    private static final String REMOVE_SPACE_BETWEEN_COMMA_PATTER = ",\\s+";


    public static Integer parseInteger(String input) {
        return Integer.parseInt(input);
    }

    public static List<String> parseStrings(String input) {
        String strings = removeSpacesBetweenCommas(input);
        return List.of(strings.split(COMMA));
    }

    public static String removeSpacesBetweenCommas(String input) {
        return input.replaceAll(REMOVE_SPACE_BETWEEN_COMMA_PATTER, COMMA);
    }
}
