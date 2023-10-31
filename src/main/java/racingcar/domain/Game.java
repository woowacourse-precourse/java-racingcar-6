package racingcar.domain;

public class Game {
    private int roundCount;
    private int executedRoundCount;

    private Game(int roundCount) {
        this.roundCount = roundCount;
        this.executedRoundCount = 0;
    }

    public static Game createNewGame(int roundCount) {
        return new Game(roundCount);
    }

    public void incrementExecutedRoundCount() {
        executedRoundCount++;
    }

    public boolean isGameEnd() {
        return executedRoundCount == roundCount;
    }
}
