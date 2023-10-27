package racingcar.validator;

public class InputValidator {
    private static final String COMMA_EXCEPTION_MESSAGE = "이름은 쉼표(,)로 구분되어야 합니다";
    private static final String CARS_LENGTH_EXCEPTION_MESSAGE = "자동차는 1개 이상이어야 합니다";
    private static final int MIN_CARS_LENGTH = 1;

    public static void validateCarNames(String names) {
        validateDividedByComma(names);
        validateNamesLength(names);
    }

    private static void validateDividedByComma(String names) {
        if (!names.contains(",")) {
            throw new IllegalArgumentException(COMMA_EXCEPTION_MESSAGE);
        }
    }

    private static void validateNamesLength(String names) {
        String[] nameArray = names.split(",");
        if (nameArray.length < MIN_CARS_LENGTH) {
            throw new IllegalArgumentException(CARS_LENGTH_EXCEPTION_MESSAGE);
        }
    }

}
