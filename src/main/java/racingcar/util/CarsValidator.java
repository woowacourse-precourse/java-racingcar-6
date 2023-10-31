package racingcar.util;

import java.util.List;

public class CarsValidator {
    private static final String DUPLICATE_INPUT = "자동차 이름이 중복입니다.";
    private static final String INVALID_NAME_COUNT = "자동차 이름은 2개 이상이어야 합니다.";
    private static final String INVALID_SEPARATOR = "자동차를 구분하는 기준은 쉼표(,)여야 합니다.";

    private CarsValidator() {
    }

    public static void validateCarNames(List<String> names) {
        validateInputCount(names);
        validateDuplicateName(names);
    }

    private static void validateDuplicateName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_INPUT);
        }
    }

    private static void validateInputCount(List<String> names) {
        if (names.size() < Constants.MIN_INPUT_COUNT) {
            throw new IllegalArgumentException(INVALID_NAME_COUNT);
        }
    }

    public static void validateInputWithSeparator(String input) {
        if (!input.contains(Constants.COMMA)) {
            throw new IllegalArgumentException(INVALID_SEPARATOR);
        }
    }
}
