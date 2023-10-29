package racingcar.validator;


import java.util.Arrays;

import static racingcar.constant.Constant.*;

public class CarNameValidator {

    private static final int MAX_LENGTH = 5; // 자동차 이름 최대 길이

    private static final String ERROR = "[ERROR] 자동차 이름은 ";
    private static final String ERROR_BLANK = ERROR + "공백을 허용하지 않습니다.";
    private static final String ERROR_MAX_LENGTH = ERROR + "최대 " + MAX_LENGTH + "글자 입니다.";
    private static final String ERROR_CONSECUTIVE_COMMA = ERROR + "연속된 " + KOREAN_COMMA_BRACKET_DELIMITER + "을 허용하지 않습니다.";

    private CarNameValidator() {}

    public static void validate(String input) {
        validateCarNamesBlankException(input);
        validateCarNamesLengthGreaterThanFive(input);
        validateCarNamesConsecutiveCommaException(input);
    }

    private static void validateCarNamesBlankException(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private static void validateCarNamesLengthGreaterThanFive(String input) {
        String[] splitList = input.split(COMMA_REGEX_DELIMITER);

        Arrays.stream(splitList)
                .filter(carName -> carName.length() > MAX_LENGTH)
                .forEach(carName -> {
                    throw new IllegalArgumentException(ERROR_MAX_LENGTH);
                });
    }

    private static void validateCarNamesConsecutiveCommaException(String input) {
        if (input.contains(CONSECUTIVE_COMMA_DELIMITER)) {
            throw new IllegalArgumentException(ERROR_CONSECUTIVE_COMMA);
        }
    }
}
