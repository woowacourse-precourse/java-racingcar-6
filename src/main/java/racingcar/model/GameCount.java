package racingcar.model;

public class GameCount {

    public static final String GAME_COUNT_EXCEEDED = "정해진 횟수를 초과했습니다.";
    public static final String GAME_COUNT_OUT_OF_RANGE = "1 ~ 100 사이의 숫자를 입력해주세요.";
    private static final int NO_MORE_COUNT = 0;


    private int count;

    private GameCount(final int count) {
        validateIfInRange(count);
        this.count = count;
    }

    public static GameCount from(final int count) {
        return new GameCount(count);
    }

    public boolean isGameOver() {
        return count == 0;
    }

    public void play() {
        count--;
        validateIfPositive();
    }

    private void validateIfInRange(final int count) {
        if (count < 1 || count > 100) {
            throw new IllegalArgumentException(GAME_COUNT_OUT_OF_RANGE);
        }
    }

    private void validateIfPositive() {
        if (count < NO_MORE_COUNT) {
            throw new UnsupportedOperationException(GAME_COUNT_EXCEEDED);
        }
    }
}
