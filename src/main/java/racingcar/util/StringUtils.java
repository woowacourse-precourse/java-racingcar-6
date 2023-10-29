package racingcar.util;

public class StringUtils {
    public static boolean isBlank(String name) {
        return name == null || name.trim().isEmpty();
    }
}
