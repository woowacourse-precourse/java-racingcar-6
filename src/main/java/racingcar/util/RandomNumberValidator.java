package racingcar.util;

public class RandomNumberValidator {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    public static void validate(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new IllegalArgumentException(Message.EXCEPTION_NUMBER_RANGE.message);
        }
    }

    public enum Message {
        EXCEPTION_NUMBER_RANGE("0 이상, 9 이상의 수가 아닙니다.");
        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
