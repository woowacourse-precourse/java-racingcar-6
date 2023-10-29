package racingcar.model;

import static racingcar.message.ExceptionMessage.GAME_COUNT_EXCEEDED;

import java.util.Arrays;

public class GameCount {

    private static final int NO_MORE_COUNT = 0;

    private int count;

    private GameCount(final int count) {
        validate(count);
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
        validateNegativity();
    }

    private void validate(final int count) {
    }

    private void validateNegativity() {
        if (count < NO_MORE_COUNT) {
            throw new UnsupportedOperationException(GAME_COUNT_EXCEEDED.getMessage());
        }
    }
}
