package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCup {
    private final int TOTAL_ROUNDS;
    private int nowRound;
    private List<String> finalWinners;
    private int topPlayerCompletedRound;

    public RacingCup(int totalRounds) {
        this.TOTAL_ROUNDS = totalRounds;
        this.nowRound = 0;
        this.finalWinners = new ArrayList<>();
        this.topPlayerCompletedRound = 0;
    }

    public boolean nextRound() {
        if (nowRound < TOTAL_ROUNDS) {
            this.nowRound++;
            return true;
        }
        return false;
    }

    public List<String> getFinalWinners() {
        return finalWinners;
    }

    public int getTopPlayerCompletedRound() {
        return topPlayerCompletedRound;
    }

    public void updateTopPlayerCompletedRound(int completedRoundOfPlayer) {
        if (topPlayerCompletedRound < completedRoundOfPlayer) {
            this.topPlayerCompletedRound = completedRoundOfPlayer;
        }
    }

    public void addCarNameOfTheWinner(String carName) {
        this.finalWinners.add(carName);
    }
}
