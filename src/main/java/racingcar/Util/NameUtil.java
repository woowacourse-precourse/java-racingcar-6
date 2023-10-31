package racingcar.Util;

import java.util.Arrays;
import java.util.List;

public class NameUtil {
    private static final String NAME_LENGTH_OVER = "이름 길이가 초과되었습니다.";
    private static final String COMMA = ",";
    private static final int MAX_LENGTH = 5;

    private NameUtil() {
    }

    public static List<String> splitName(String carsName) {
        return Arrays.asList(carsName.split(COMMA));
    }

    public static void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_OVER);
        }
    }
}