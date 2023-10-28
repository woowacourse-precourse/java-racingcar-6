package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final int INPUT_NAME_MAX_LENGTH = 5;
    private static final int INPUT_MINIMUM_LOOP = 1;

    public static void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > INPUT_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("유효하지 않은 이름 입력");
        }
    }

    public static void validateDuplicateNames(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() < names.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다");
        }
    }

    public static void validatePositiveInteger(int inputLoop) {
        try {
            if (inputLoop < INPUT_MINIMUM_LOOP) {
                throw new IllegalArgumentException("입력 수 오류");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 수 오류");
        }
    }
}