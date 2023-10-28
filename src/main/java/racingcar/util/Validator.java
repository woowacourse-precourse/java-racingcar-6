package racingcar.util;

public class Validator {

    private static final String BLANK_ERROR_MESSAGE = "값을 입력해 주세요.";

    public static void isBlankInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

}
