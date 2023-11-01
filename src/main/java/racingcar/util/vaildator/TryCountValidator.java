package racingcar.util.vaildator;

public class TryCountValidator {
    private static final String INPUT_TRYCOUNT_ZERO_EXCEPTION = "0 이상의 숫자를 입력해주세요.";

    public static void validateInputTryCount(String tryCount) {
        int inputTryCount = Integer.parseInt(tryCount);
        if (inputTryCount == 0) {
            throw new IllegalArgumentException(INPUT_TRYCOUNT_ZERO_EXCEPTION);
        }
    }
}
