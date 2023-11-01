package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int INPUT_NAME_MAX_LENGTH = 5;
    private static final int INPUT_MINIMUM_LOOP = 1;

    private static void validateNotNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("유효하지 않은 이름 입력(NULL)");
        }
    }

    private static void validateNotBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 이름 입력(공백)");
        }
    }

    private static void validateMaxLength(String name) {
        if (name.length() > INPUT_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 이름 입력(길이 초과)");
        }
    }

    private static void validateNoSpacesBetweenNames(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("유효하지 않은 이름 입력(이름 사이 공백)");
        }
    }

    public static void validateEndsWith(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(",로 문장이 마쳐졌습니다.");
        }
    }
}
