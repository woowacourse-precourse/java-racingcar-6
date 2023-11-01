package racingcar.validator;

public class TryCountValidator {

    public static void validateTryCountIsInteger(String tryCount) {

        try {
            validateTryCountIsZero(Integer.parseInt(tryCount));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void validateTryCountIsZero(Integer tryCount) {

        if (tryCount == 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
        }
    }
}
