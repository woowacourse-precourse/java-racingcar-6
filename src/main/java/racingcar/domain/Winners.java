package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private List<String> winners = new ArrayList<>();

    public Winners(List<String> winnerList) {
        for (String winner : winnerList) {
            winners.add(winner);
        }
    }

    public String makeWinnerList() {
        String winnerList = String.join(", ", winners);
        return winnerList;
    }
}
