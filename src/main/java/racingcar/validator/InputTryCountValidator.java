package racingcar.validator;

public class InputTryCountValidator {
    private static final String NON_INPUT_ERROR_MESSAGE = "입력하지 않으셨습니다. 시도할 회수를 입력해주세요.";
    private static final String NON_INTEGER_ERROR_MESSAGE = "시도 횟수는 숫자만 가능합니다.";
    private static final String NON_OVER_ONE_ERROR_MESSAGE = "시도 횟수는 1이상으로 입력해주세요.";
    private static final String MINUS_COUNT_ERROR_MESSAGE = "마이너스는 입력 할 수 없습니다.";

    public void validateNonInputTryCount(String tryCount) {
        if (tryCount.equals("")) {
            throw new IllegalArgumentException(NON_INPUT_ERROR_MESSAGE);
        }
    }

    public void validateNonIntegerTryCount(String tryCount) {
        try {
            Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_ERROR_MESSAGE);
        }
    }

    public void validateNonOverOneTryCount(String tryCount) {
        if (Integer.parseInt(tryCount) < 1) {
            throw new IllegalArgumentException(NON_OVER_ONE_ERROR_MESSAGE);
        }
    }

    public void validateMinusTryCount(String tryCount) {
        String[] valNumber = tryCount.split("");

        for (String number : valNumber) {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException(MINUS_COUNT_ERROR_MESSAGE);
            }
        }
    }
}
