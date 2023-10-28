package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCup {
    private final int FINAL_ROUND;
    private int round;
    private List<Player> playerList;
    private List<String> winners;

    public RacingCup(int FINAL_ROUND) {
        this.FINAL_ROUND = FINAL_ROUND;
        this.round = 0;
        this.playerList = new ArrayList<>();
        this.winners = new ArrayList<>();
    }

    public int getFINAL_ROUND() {
        return FINAL_ROUND;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
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

    @Override
    public String toString() {
        return "RacingCup{" +
                "FINAL_ROUND=" + FINAL_ROUND +
                ", round=" + round +
                ", playerList=" + playerList +
                ", winners=" + winners +
                '}';
    }
}
