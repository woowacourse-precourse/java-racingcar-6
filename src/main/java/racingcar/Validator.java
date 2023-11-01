package racingcar;

public class Validator {

    private static final String INVALID_INPUT_BLANK = "잘못된 입력값입니다.(빈칸 혹은 공백)";
    private static final String INVALID_INPUT_NOT_INTEGER = "정수만 입력해 주세요.";

    public static void validateIsBlank(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException(INVALID_INPUT_BLANK);
        }
    }

    public static void validateIsInteger(String value) {
        if (!isInteger(value)) {
            throw new IllegalArgumentException(INVALID_INPUT_NOT_INTEGER);
        }
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Validator() {
    }
}