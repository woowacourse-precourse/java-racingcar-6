package racingcar.repository;

import racingcar.domain.Winner;

public class WinnerRepository {

    private Winner winner;

    public WinnerRepository() {
        this.winner = new Winner();
    }

    public void add(String name) {
        winner.init(name);
    }
}
