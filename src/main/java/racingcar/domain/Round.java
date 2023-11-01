package racingcar.domain;

public class Round {
    private final int totalRound;
    private int currentRound = 0;

    public Round(int totalRound) {
        this.totalRound = totalRound;
    }
    public void riseRound(){
        currentRound += 1;
    }
    public boolean isGameInProgress(){
        return totalRound != currentRound;
    }
}
