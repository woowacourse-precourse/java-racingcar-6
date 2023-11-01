package racingcar.exception;

public class MoveNumberException {
    private final static String INVALID_NEGATIVE_NUMBER = "이동할 횟수는 음수가 아니어야 합니다.";
    private final static String INVALID_NUMBER_FORMAT = "이동할 횟수는 숫자여야 합니다.";
    private final static int MIN_RANGE = 1;

    public static void validateMoveNumberRange(int number) {
        if (number < MIN_RANGE) {
            throw new IllegalArgumentException(INVALID_NEGATIVE_NUMBER);
        }
    }

    public static void validateFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
        }
    }
}
