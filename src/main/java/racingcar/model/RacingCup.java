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

    public int getTopPlayerCompletedRound() {
        return topPlayerCompletedRound;
    }

    public void setTopPlayerCompletedRound(int round) {
        this.topPlayerCompletedRound = round;
    }

    public int getTOTAL_ROUNDS() {
        return TOTAL_ROUNDS;
    }

    public int getNowRound() {
        return nowRound;
    }

    public void setNowRound(int nowRound) {
        this.nowRound = nowRound;
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
}
