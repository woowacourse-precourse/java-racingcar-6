package racingcar.util.vaildator;

import java.util.regex.Pattern;

public class TryCountValidator {
    private static final Pattern REGEX_NUMERIC = Pattern.compile("^[0-9]\\d*$");
    private static final String INPUT_TRYCOUNT_ZERO_EXCEPTION = "1 이상의 숫자를 입력해주세요.";
    private static final String INPUT_TRYCOUNT_NOTHING_EXCEPTION = "아무것도 입력하지 않았습니다. 1 이상의 숫자를 입력해주세요.";
    private static final String INPUT_TRYCOUNT_NUMERIC_EXCEPTION = "1 이상의 자연수만 입력해주세요";

    public static void validateInput(String tryCount) {
        validateInputTryCount(tryCount);
        validateInputTryCountNothing(tryCount);
        validateInputTryCountNumeric(tryCount);
    }

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

    public static void validateInputTryCountNumeric(String tryCount) {
        if (!REGEX_NUMERIC.matcher(tryCount).matches()) {
            throw new IllegalArgumentException(INPUT_TRYCOUNT_NUMERIC_EXCEPTION);
        }
    }
}
