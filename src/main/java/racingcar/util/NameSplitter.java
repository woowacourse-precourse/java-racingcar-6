package racingcar.util;

public class NameSplitter {

    private static final String DELIMITER = ",";

    public static String[] split(final String input) {
        return input.split(DELIMITER);
    }
}
