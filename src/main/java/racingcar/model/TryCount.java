package racingcar.model;

public class TryCount {

    private static final int MIN_TRY_COUNT = 1;
    private static final String INVALID_TRY_COUNT = String.format("시도 횟수는 %d 이상 입력해 주세요", MIN_TRY_COUNT);
    private int tryCount;

    public TryCount(String tryCount) {
        this.tryCount = validateTryCount(tryCount);
    }

    public int getTryCount() {
        return tryCount;
    }

    private int validateTryCount(String tryCount) {
        int validateNumber = Integer.parseInt(tryCount);
        if (validateNumber < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT);
        }
        return validateNumber;
    }
}
