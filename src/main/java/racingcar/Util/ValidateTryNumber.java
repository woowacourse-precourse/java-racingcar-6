package racingcar.Util;

public class ValidateTryNumber {
    private static final String TRY_NUMBER_IS_NOT_POSITIVE = "입력한 시도 횟수가 양수가 아닙니다.";

    public static void validateTryNumberIsPositive(int tryNumber) throws IllegalArgumentException {
        if (tryNumber < 1) {
            throw new IllegalArgumentException(TRY_NUMBER_IS_NOT_POSITIVE);
        }
    }
}
