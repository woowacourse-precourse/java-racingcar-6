package racingcar.util;

public class NameSplitter {

    private static final String DELIMITER = ",";

    public static String[] split(String input) {
        return input.split(DELIMITER);
    }
}
