package racingcar.model;

import static racingcar.ExceptionMessage.PLAY_COUNT_VALUE_EXCEPTION;

public class PlayCount {

    private static final int INITIAL_COUNT = 0;
    private int count;
    private final int goal;

    private PlayCount(final String goal) {
        validateValue(goal);
        this.count = INITIAL_COUNT;
        this.goal = Integer.parseInt(goal);
    }

    private void validateValue(final String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(PLAY_COUNT_VALUE_EXCEPTION.getMessage());
        }
    }

    public static PlayCount from(final String input) {
        return new PlayCount(input);
    }

    public void endOneRound() {
        count++;
    }

    public boolean isPlayEnd() {
        return count >= goal;
    }
}
