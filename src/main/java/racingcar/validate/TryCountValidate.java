package racingcar.validate;

public class TryCountValidate {
    public static void validateTryCount(String tryCount) {
        isInputNumber(tryCount);
        isInputNegative(tryCount);
    }

    private static void isInputNumber(String tryCount) {
        if (tryCount.matches("[^0-9]")) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private static void isInputNegative(String tryCount) {
        if (Integer.parseInt(tryCount) < 0) {
            throw new IllegalArgumentException("정수만 입력해주세요.");
        }
    }
}
