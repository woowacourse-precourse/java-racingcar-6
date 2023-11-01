package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private List<String> winners;

    public Winners() {
        winners = new ArrayList<>();
    }

    public void addWinner(String winner) {
        winners.add(winner);
    }

    public int size() {
        return winners.size();
    }

    public String get(int index) {
        return winners.get(index);
    }

}
