package racingcar.validator;

import static racingcar.constant.Constant.*;

public class CarNameValidator {

    private static final int MIN_LENGTH = 1; // 자동차 이름 최소 길이
    private static final int MAX_LENGTH = 5; // 자동차 이름 최대 길이

    private static final String ERROR = "[ERROR] 자동차 이름은 ";
    private static final String ERROR_BLANK = ERROR + "공백을 허용하지 않습니다.";
    private static final String ERROR_MAX_LENGTH = ERROR + "최대 " + MAX_LENGTH + "글자 입니다.";

    private CarNameValidator() {}

    public static void validate(final String input) {
        validateCarNameBlankException(input);
        validateCarNameLengthGreaterThanFive(input);
    }

    private static void validateCarNameBlankException(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private static void validateCarNameLengthGreaterThanFive(final String input) {
        String[] splitList = input.split(COMMA_DELIMITER);
        for (String carName : splitList) {
            int carNameLength = carName.length();
            if (carNameLength < MIN_LENGTH || carNameLength > MAX_LENGTH) {
                throw new IllegalArgumentException(ERROR_MAX_LENGTH);
            }
        }
    }
}
