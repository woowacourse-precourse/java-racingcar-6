package racingcar.repository;

import racingcar.domain.Winner;

public class WinnerRepository {

    private final Winner winner;

    public WinnerRepository() {
        this.winner = new Winner();
    }

    public void add(String name) {
        winner.init(name);
    }

    public String convertListToString() {
        return winner.toString();
    }
}
