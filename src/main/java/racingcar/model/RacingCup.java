package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCup {
    private final int TOTAL_ROUNDS;
    private int nowRound;
    private List<Player> playerList;
    private List<String> winners;
    private int topPlayerCompletedRound;

    public RacingCup(int totalRounds) {
        this.TOTAL_ROUNDS = totalRounds;
        this.nowRound = 0;
        this.playerList = new ArrayList<>();
        this.winners = new ArrayList<>();
        this.topPlayerCompletedRound = 0;
    }

    public boolean nextRound() {
        if(nowRound < TOTAL_ROUNDS) {
            this.nowRound++;
            return true;
        }
        return false;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<String> getWinners() {
        return winners;
    }

    public void setWinners(List<String> winners) {
        this.winners = winners;
    }

    public int getTopPlayerCompletedRound() {
        return topPlayerCompletedRound;
    }

    public void updateTopPlayerCompletedRound(int completedRoundOfPlayer) {
        if (topPlayerCompletedRound < completedRoundOfPlayer) {
            this.topPlayerCompletedRound = completedRoundOfPlayer;
        }
    }
}
