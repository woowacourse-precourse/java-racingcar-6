package racingcar.domain;

public class GameRound {

    private final int totalRound;
    private int currentRound;

    public GameRound(int totalRound, int currentRound) {
        this.totalRound = totalRound;
        this.currentRound = currentRound;
    }
}
