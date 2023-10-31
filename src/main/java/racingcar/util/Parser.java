package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String SEPARATOR = ",";

    public static int parseStringToInt(String input) throws IllegalArgumentException{
        return Integer.parseInt(input);
    }

    public static List<String> parseCarNames(String input) {
        return Arrays.asList(input.split(SEPARATOR, -1));
    }
}
