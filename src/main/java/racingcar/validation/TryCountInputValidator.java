package racingcar.validation;

public class TryCountInputValidator {
    private static final String ZERO_EXCEPTION_MESSAGE = "입력값이 0이 될 수 없습니다.";
    private static final String NON_DIGIT_EXCEPTION_MESSAGE = "입력값이 숫자가 아닙니다.";

    public void validateInputTryCount(String tryCount) {
        checkInputZero(tryCount);
        checkInputDigit(tryCount);
    }

    private void checkInputZero(String tryCount) {
        if (tryCount.equals("0")) {
            throw new IllegalArgumentException(ZERO_EXCEPTION_MESSAGE);
        }
    }

    private void checkInputDigit(String tryCount) {
        for (int i = 0; i < tryCount.length(); i++) {
            if (!Character.isDigit(tryCount.charAt(i))) {
                throw new IllegalArgumentException(NON_DIGIT_EXCEPTION_MESSAGE);
            }
        }
    }
}
