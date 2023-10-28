package racingcar.util;

import java.util.List;

public class StringUtils {
    private static final String BLANK_ERROR_FORMAT = "입력값이 null 이거나 빈 값일 수 없습니다.";
    private static final String NUMBER_ERROR_FORMAT = "입력값이 숫자가 아닙니다.";
    private StringUtils() {
    }

    public static List<String> splitByComma(String input) {
        validateNotBlank(input);
        return List.of(input.split(","));
    }

    public static int parseInt(String input) {
        validateNumberString(input);
        return Integer.parseInt(input);
    }

    private static void validateNumberString(String input) {
        validateNotBlank(input);
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(NUMBER_ERROR_FORMAT);
            }
        }
    }

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR_FORMAT);
        }
    }
}
