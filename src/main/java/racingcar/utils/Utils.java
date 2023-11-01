package racingcar.utils;

public class Utils {
    private static final String COMMA = ",";

    public static String[] splitStringByComma(final String str) {
        return str.split(COMMA);
    }
}
