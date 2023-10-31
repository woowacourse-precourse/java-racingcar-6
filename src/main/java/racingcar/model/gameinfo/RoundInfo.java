package racingcar.model.gameinfo;

public class RoundInfo {
    private final int maxRound;
    private int currentRound;

    public RoundInfo(int maxRound) {
        this.currentRound = 1;
        this.maxRound = maxRound;
    }

    public void finishRound() {
        this.currentRound = this.currentRound + 1;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public int getMaxRound() {
        return maxRound;
    }


}
