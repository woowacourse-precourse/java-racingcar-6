package racingcar;

import java.util.Arrays;
import java.util.List;

public class Util {

    private static final String SPACE = " ";
    private static final String NO_SPACE = "";
    private static final String COMMA = ",";

    public static String removeSpace(String input) {
        return input.replaceAll(SPACE, NO_SPACE);
    }

    public static String[] splitByComma(String input) {
        return input.split(COMMA);
    }

    public static List<String> arrayToList(String[] array) {
        return Arrays.asList(array);
    }
}