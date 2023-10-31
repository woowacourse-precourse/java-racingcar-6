package racingcar.util;

import java.util.List;

public class InputViewValidator {
    private final static String INVALID_SEPARATOR_MESSAGE = "자동차를 구분하는 기준은 쉼표(,)여야 합니다.";
    private final static String INVALID_NAME_COUNT_MESSAGE = "자동차 이름은 2개 이상이어야 합니다.";

    public static void validateInputWithSeparator(String input) {
        if (!input.contains(Constants.COMMA)) {
            throw new IllegalArgumentException(INVALID_SEPARATOR_MESSAGE);
        }
    }

    public static void validateInputCount(List<String> names) {
        if (names.size() < Constants.MIN_INPUT_COUNT) {
            throw new IllegalArgumentException(INVALID_NAME_COUNT_MESSAGE);
        }
    }
}
