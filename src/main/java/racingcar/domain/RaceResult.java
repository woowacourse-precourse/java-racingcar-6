package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private final List<String> winners = new ArrayList<>();

    public List<String> getWinners() {
        return new ArrayList<>(winners);
    }

    public void addWinner(String name) {
        winners.add(name);
    }
}
