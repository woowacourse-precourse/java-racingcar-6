package racingcar.validator;

import java.util.Arrays;

public class InputValidator {
    private static final String COMMA_EXCEPTION_MESSAGE = "이름은 쉼표(,)로 구분되어야 합니다";
    private static final String CARS_LENGTH_EXCEPTION_MESSAGE = "자동차는 1개 이상이어야 합니다";
    private static final String DUPLICATED_NAME_EXCEPTION_MESSAGE = "중복되는 이름이 있습니다";
    private static final int MIN_CARS_LENGTH = 1;

    public static void validateCarNames(String names) {
        validateDividedByComma(names);
        String[] nameArray = names.split(",");
        validateNamesLength(nameArray);
        validateDuplicatedName(nameArray);
    }

    private static void validateDividedByComma(String names) {
        if (!names.contains(",")) {
            throw new IllegalArgumentException(COMMA_EXCEPTION_MESSAGE);
        }
    }

    private static void validateNamesLength(String[] nameArray) {
        if (nameArray.length < MIN_CARS_LENGTH) {
            throw new IllegalArgumentException(CARS_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private static void validateDuplicatedName(String[] nameArray) {
        if (Arrays.asList(nameArray).stream().distinct().count() != nameArray.length) {
            throw new IllegalArgumentException(DUPLICATED_NAME_EXCEPTION_MESSAGE);
        }
    }

}
