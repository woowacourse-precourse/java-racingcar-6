package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Rounds {
    private final List<Round> rounds = new ArrayList<>();

    public void makeRounds(Integer totalRounds) {
        for (int i = 0; i < totalRounds; i++) {
            rounds.add(new Round());
        }
    }

    public List<Round> getRounds() {
        return rounds;
    }
}
