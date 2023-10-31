package racingcar.util;

public class StringUtil {
    public static String[] splitString(String string) {
        return string.replace(" ", "").split(",");
    }
}
