package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private List<String> winners = new ArrayList<>();

    public int getWinnersCount() {
        if (winners == null) {
            return 0;
        } else {
            return winners.size();
        }
    }

    public void addWinner(String winner) {
        winners.add(winner);
    }

    public String winnersResult() {
        return winners.stream().collect(Collectors.joining(", "));
    }
}
