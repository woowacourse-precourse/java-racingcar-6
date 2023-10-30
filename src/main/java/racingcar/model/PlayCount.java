package racingcar.model;

public class PlayCount {

    private static final int DEFAULT_COUNT = 0;

    private final int goal;

    private int round;

    private PlayCount(final int goal) {
        this.goal = goal;
    }

    public static PlayCount createDefault(final String goal) {
        validate(goal);
        return new PlayCount(Integer.parseInt(goal));
    }

    private static void validate(final String goal) {
        if (!goal.matches("[0-9]+")) {
            throw new IllegalArgumentException("횟수는 양수여야 합니다.");
        }
    }

    public void endOneRound() {
        round++;
    }

    public boolean isGameEnd() {
        return round == goal;
    }
}
