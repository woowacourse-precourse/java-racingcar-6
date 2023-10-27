package racingcar.domain;

public class GameRound {

    private final int totalRound;
    private int currentRound;

    public GameRound(int totalRound, int currentRound) {
        validateTotalRound(totalRound);
        this.totalRound = totalRound;
        this.currentRound = currentRound;
    }

    private void validateTotalRound(int totalRound) {
        if (totalRound < 1) {
            throw new IllegalArgumentException();
        }
    }
}
