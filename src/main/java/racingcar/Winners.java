package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<String> winners = new ArrayList<>();

    public Winners() {
    }

    public int getWinnersCount() {
        if (winners == null) {
            return 0;
        }

        return winners.size();
    }

    public void addWinner(String winner) {
        winners.add(winner);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int length = getWinnersCount();

        sb.append(winners.get(0));
        for (int i = 1; i < length; i++) {
            sb.append(", ").append(winners.get(i));
        }

        return sb.toString();
    }

}
