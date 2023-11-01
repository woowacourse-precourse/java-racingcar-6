package racingcar.util;

public class Validator {

    public static final String EMPTY = "값을 입력해주세요.";
    public static final String NO_DIGIT = "숫자를 입력해주세요.";

    public static void validateNotEmpty(final String target) {
        if (target.isEmpty()) {
            throw new IllegalArgumentException(EMPTY);
        }
    }

    public static void validateInteger(final String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NO_DIGIT);
        }
    }
}
