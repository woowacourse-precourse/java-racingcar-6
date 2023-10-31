package racingcar.util;

public class StringUtil {
    public static String[] splitString(String string) {
        String[] arr = string.replace(" ", "").split(",");
        return arr;
    }
}
