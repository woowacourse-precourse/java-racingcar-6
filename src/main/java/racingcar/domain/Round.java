package racingcar.domain;

public class Round {
    private final int totalRound;
    private int thisRound = 0;

    public Round(int totalRound) {
        this.totalRound = totalRound;
    }
    public void riseRound(){
        thisRound += 1;
    }
    public boolean checkEndGame(){
        return totalRound == thisRound;
    }
}
