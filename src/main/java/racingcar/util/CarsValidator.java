package racingcar.util;

import java.util.List;

public class CarsValidator {
    private static final String DUPLICATE_INPUT = "자동차 이름이 중복입니다.";

    private CarsValidator() {
    }

    public static void validateDuplicateName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_INPUT);
        }
    }
}
