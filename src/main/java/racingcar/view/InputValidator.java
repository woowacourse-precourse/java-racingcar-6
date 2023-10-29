package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

public final class InputValidator {
    private final static String EMPTY_BLANK_NAME_MESSAGE = "자동차 이름은 공백 또는 빈값일 수 없습니다.";
    private final static String DUPLICATION_NAME_MESSAGE = "중복된 자동차 이름을 사용할 수 없습니다";
    private final static String POSITIVE_VALUE_MESSAGE = "시도 횟수는 양수 값만 가능 합니다.";

    private InputValidator() {
    }

    public static void checkBlankAndDuplicationName(List<String> names) {
        if (isBlankOrEmptyName(names)) {
            throw new IllegalArgumentException(EMPTY_BLANK_NAME_MESSAGE);
        }

        if (isDuplicationName(names)) {
            throw new IllegalArgumentException(DUPLICATION_NAME_MESSAGE);
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

    private static Boolean isDuplicationName(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                .values()
                .stream()
                .anyMatch(c -> c >= 2);
    }

}
