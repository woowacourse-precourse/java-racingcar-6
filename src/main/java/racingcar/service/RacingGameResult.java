package racingcar.service;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    List<String> winners;
    RacingGameResult() {
        winners = new ArrayList<>();
    }

    public void addWinner(String name) {
        winners.add(name);
    }

    public void clear() {
        winners.clear();
    }

    public List<String> getWinners() {
        return winners;
    }
}
