package racingcar.util.vaildator;

public class TryCountValidator {
    private static final String INPUT_TRYCOUNT_ZERO_EXCEPTION = "1 이상의 숫자를 입력해주세요.";
    private static final String INPUT_TRYCOUNT_NOTHING_EXCEPTION = "아무것도 입력하지 않았습니다. 1 이상의 숫자를 입력해주세요.";

    public static void validateInputTryCount(String tryCount) {
        int inputTryCount = Integer.parseInt(tryCount);
        if (inputTryCount == 0) {
            throw new IllegalArgumentException(INPUT_TRYCOUNT_ZERO_EXCEPTION);
        }
    }

    public static void validateInputTryCountNothing(String tryCount) {
        if (tryCount.isEmpty()) {
            throw new IllegalArgumentException(INPUT_TRYCOUNT_NOTHING_EXCEPTION);
        }
    }
}
