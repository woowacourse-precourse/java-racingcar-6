package racingcar.vo;

public class RoundCount {
    private static final int MINIMUM_ROUND_COUNT = 1;
    private static final String MINIMUM_ROUND_ERROR_MESSAGE = "이동횟수는 1 이상이어야 합니다.";

    private final int count;

    public RoundCount(int count) {
        validateBiggerThanMinimum(count);
        this.count = count;
    }

    private void validateBiggerThanMinimum(int count) {
        if (count < MINIMUM_ROUND_COUNT) {
            throw new IllegalArgumentException(MINIMUM_ROUND_ERROR_MESSAGE);
        }
    }

    public int getCount() {
        return count;
    }
}
