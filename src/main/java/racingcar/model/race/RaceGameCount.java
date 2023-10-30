package racingcar.model.race;

public class RaceGameCount {

    public static final String GAME_COUNT_OUT_OF_RANGE = "1 ~ 100 사이의 숫자를 입력해주세요.";
    public static final String GAME_COUNT_EXCEEDED = "정해진 횟수를 초과했습니다.";

    private static final int NO_MORE_GAME_COUNT = 0;
    private static final int GAME_COUNT_MIN = 1;
    private static final int GAME_COUNT_MAX = 100;

    private int count;

    private RaceGameCount(final int count) {
        validateIfInRange(count);
        this.count = count;
    }

    public static RaceGameCount from(final int count) {
        return new RaceGameCount(count);
    }

    public boolean isGameOver() {
        return count == NO_MORE_GAME_COUNT;
    }

    public void run() {
        count--;
        validateIfPositive();
    }

    private void validateIfInRange(final int count) {
        if (isNotInRange(count)) {
            throw new IllegalArgumentException(GAME_COUNT_OUT_OF_RANGE);
        }
    }

    private void validateIfPositive() {
        if (isNegative()) {
            throw new IllegalArgumentException(GAME_COUNT_EXCEEDED);
        }
    }

    private boolean isNotInRange(final int count) {
        return count < GAME_COUNT_MIN || count > GAME_COUNT_MAX;
    }

    private boolean isNegative() {
        return count < NO_MORE_GAME_COUNT;
    }
}
