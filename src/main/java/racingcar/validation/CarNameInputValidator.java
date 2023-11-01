package racingcar.validation;

public class CarNameInputValidator {

    private static final String INVALID_INPUT_MESSAGE = "자동차 이름은 쉼표(,) 기준으로 구분하여 입력해야 합니다.";

    public static void validateInput(String input) {
        if (input == null) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        if (!containsAtLeastOneComma(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        if (containsConsecutiveCommas(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    private static boolean containsAtLeastOneComma(String input) {
        return input.chars().filter(ch -> ch == ',').count() >= 1;
    }

    private static boolean containsConsecutiveCommas(String input) {
        return input.contains(",,");
    }
}
