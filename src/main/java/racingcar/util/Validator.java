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

}
