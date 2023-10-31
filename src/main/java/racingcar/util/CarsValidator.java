package racingcar.util;

import java.util.List;

public class CarsValidator {
    private final static String DUPLICATE_INPUT_MESSAGE = "자동차 이름이 중복입니다.";

    public static void validateDuplicateName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_INPUT_MESSAGE);
        }
    }
}
