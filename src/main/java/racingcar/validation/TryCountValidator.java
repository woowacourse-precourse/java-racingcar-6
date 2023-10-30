package racingcar.validation;

public class TryCountValidator {

    public static int validateTryCount(String input) {
        validateInputEmpty(input);
        int tryCount = parseInputToInteger(input);
        validateTryCountBiggerThanZero(tryCount);
        return tryCount;
    }

    private static int parseInputToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력하세요.");
        }
    }

    private static void validateInputEmpty(String input) {
        if (input == null || input.length() == 0) {
            throw new IllegalArgumentException("시도할 횟수를 입력하지 않았습니다. 숫자를 입력해주세요.");
        }
    }

    private static void validateTryCountBiggerThanZero(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 0보다 커야 합니다.");
        }
    }

}
