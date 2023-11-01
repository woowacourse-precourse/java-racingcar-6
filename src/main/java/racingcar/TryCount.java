package racingcar;

public class TryCount {
    private static final int MIN_VALUE_TRY_COUNT = 1;
    private static final String ERROR_MIN_TRY_COUNT = "시도 횟수는 1 이상이어야 합니다.";
    private static final String ERROR_PARSE_TRY_COUNT = "시도 횟수는 숫자 형식을 만족해야 합니다.";

    private int tryCount;

    public TryCount(String tryCount) {
        this.tryCount = parseToInteger(tryCount);
        validateTryCount(this.tryCount);
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MIN_VALUE_TRY_COUNT) {
            throw new IllegalArgumentException(ERROR_MIN_TRY_COUNT);
        }
    }

    private int parseToInteger(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PARSE_TRY_COUNT);
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}