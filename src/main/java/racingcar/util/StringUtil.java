package racingcar.util;

public class StringUtil {

    private StringUtil() {}

    public static String[] splitByDelimiter(String inputString, String delimiter) {
        return inputString.split(delimiter);
    }
}
