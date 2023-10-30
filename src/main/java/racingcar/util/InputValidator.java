package racingcar.util;

import java.util.List;

public final class InputValidator {
    private final static String EMPTY_BLANK_NAME_MESSAGE = "자동차 이름은 공백 또는 빈값일 수 없습니다.";
    private final static String POSITIVE_VALUE_MESSAGE = "시도 횟수는 양수 값만 가능 합니다.";

    private InputValidator() {
    }

    public static void checkEmptyAndBlankNames(List<String> names) {
        if (isBlankOrEmptyName(names)) {
            throw new IllegalArgumentException(EMPTY_BLANK_NAME_MESSAGE);
        }
    }

    public static void checkPositiveValue(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(POSITIVE_VALUE_MESSAGE);
        }
    }

    private static Boolean isBlankOrEmptyName(List<String> names) {
        return names.stream()
                .anyMatch(String::isBlank);
    }

}
