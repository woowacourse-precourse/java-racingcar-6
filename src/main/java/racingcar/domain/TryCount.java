package racingcar.domain;

import racingcar.util.ExceptionMessage;

public class TryCount {

    private static final int MIN_TRY_COUNT = 1;
    private static final int MAX_TRY_COUNT = 15;

    private final int tryCount;

    public TryCount(int tryCount) {
        validateSize(tryCount);
        this.tryCount = tryCount;
    }

    private void validateSize(int tryCount) {
        if (tryCount < MIN_TRY_COUNT || tryCount > MAX_TRY_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.GAME_TRY_COUNTS_SIZE);
        }
    }

    public int getTryCount() {
        return this.tryCount;
    }
}
