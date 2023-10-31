package racingcar.domain;

public class Count {

    private static final int MIN_TOTAL_COUNT = 1;

    private final int totalCount;

    private Count(int totalCount) {
        validate(totalCount);
        this.totalCount = totalCount;
    }

    private void validate(int totalCount) {
        if (isOutOfRange(totalCount)) {
            throw new IllegalArgumentException("시도 횟수는 1 이상 이어야 합니다");
        }
    }

    private boolean isOutOfRange(int totalCount) {
        return totalCount < MIN_TOTAL_COUNT;
    }

    public static Count from(int totalCount) {
        return new Count(totalCount);
    }

    public void repeat(Runnable runnable) {
        for (int count = 0; count < totalCount; count++) {
            runnable.run();
        }
    }
}
