package racingcar.util;

import java.util.regex.Pattern;

public class MoveCountValidator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

    public static void validateNumeric(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(Message.EXCEPTION_NUMERIC.message);
        }
    }

    private static void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number == 0) {
            throw new IllegalArgumentException(Message.EXCEPTION_NUMBER_RANGE.message);
        }
    }

    public static void validate(String input) throws IllegalArgumentException {
        validateNumeric(input);
        validateNumberRange(input);
    }

    public enum Message {
        EXCEPTION_NUMERIC("자연수만 입력 가능합니다."),
        EXCEPTION_NUMBER_RANGE("시도 회수는 1회 이상이어야 합니다."),
        EXCEPTION_INT_RANGE("int 범위를 초과하는 입력은 불가능합니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
