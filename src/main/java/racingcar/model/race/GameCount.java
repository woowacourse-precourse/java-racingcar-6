package racingcar.model.race;

public class GameCount {

    public static final String GAME_COUNT_OUT_OF_RANGE = "1 ~ 100 사이의 숫자를 입력해주세요.";

    private static final int NO_MORE_GAME_COUNT = 0;
    private static final int GAME_COUNT_MIN = 1;
    private static final int GAME_COUNT_MAX = 100;

    private int count;

    private GameCount(final int count) {
        validateInRange(count);
        this.count = count;
    }

    public static GameCount from(final int count) {
        return new GameCount(count);
    }

    public boolean isGameOver() {
        return count == NO_MORE_GAME_COUNT;
    }

    public void run() {
        count--;
    }

    private void validateInRange(final int count) {
        if (isNotInRange(count)) {
            throw new IllegalArgumentException(GAME_COUNT_OUT_OF_RANGE);
        }
    }

    private boolean isNotInRange(final int count) {
        return count < GAME_COUNT_MIN || count > GAME_COUNT_MAX;
    }
}
