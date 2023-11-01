package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int INPUT_NAME_MAX_LENGTH = 5;
    private static final int INPUT_MINIMUM_LOOP = 1;

    public static void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("유효하지 않은 이름 입력(NULL)");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 이름 입력(공백)");
        }
        if (name.length() > INPUT_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 이름 입력(길이초과)");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("유효하지 않은 이름 입력(이름 사이 공백)");
        }
    }

    public static void validateEndsWith(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(",로 문장이 마쳐졌습니다.");
        }
    }

    public static void validateDuplicateNames(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() < names.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public static void validatePositiveInteger(int inputLoop) {
        if (inputLoop < INPUT_MINIMUM_LOOP) {
            throw new IllegalArgumentException("입력 수는 양의 정수여야 합니다.");
        }
    }
}
