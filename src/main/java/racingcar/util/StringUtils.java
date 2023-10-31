package racingcar.util;

public class StringUtils {
    public static boolean isBlank(String name) {
        return name == null || name.strip().isEmpty();
    }

    public static String[] splitByDelimiter(String carNames) {
        return carNames.split(",");
    }
}
