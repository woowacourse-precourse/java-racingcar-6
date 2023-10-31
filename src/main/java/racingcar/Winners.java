package racingcar;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int str = getWinnersCount();

        if(str>0) {
            sb.append(winners.get(0));
        }

        for(int i=1; i<str; i++) {
            sb.append(", ").append(winners.get(i));
        }
        return sb.toString();
    }
}
