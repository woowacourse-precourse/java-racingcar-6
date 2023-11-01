package racingcar.model;

import static racingcar.view.exception.InputException.PLAY_COUNT_VALUE_EXCEPTION;

public class PlayCount {

    private static final int DEFAULT_ROUND = 0;

    private final int goal;
    private int round;

    private PlayCount(final int goal, final int round) {
        this.goal = goal;
        this.round = round;
    }

    public static PlayCount createDefault(final String goal) {
        validate(goal);
        return new PlayCount(Integer.parseInt(goal), DEFAULT_ROUND);
    }

    private static void validate(final String goal) {
        if (!goal.matches("[0-9]+")) {
            throw new IllegalArgumentException(PLAY_COUNT_VALUE_EXCEPTION.getMessage());
        }
    }

    public void endOneRound() {
        round++;
    }

    public boolean isGameEnd() {
        return round == goal;
    }
}
