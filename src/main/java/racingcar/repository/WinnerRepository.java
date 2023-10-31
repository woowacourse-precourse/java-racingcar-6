package racingcar.repository;

import racingcar.domain.Winner;

public class WinnerRepository {

    private final Winner winner;

    private int winnerNum = 0;

    public WinnerRepository() {
        this.winner = new Winner();
    }

    public void add(String name) {
        winner.init(name);
    }

    public void saveNum(int num) {
        winnerNum = num;
    }

    public boolean isWinner(int num) {
        return winnerNum == num;
    }

    public String convertListToString() {
        return winner.toString();
    }
}
