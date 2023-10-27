package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private List<String> winners = new ArrayList<>();

    public Winners(List<String> winnerList) {
        winners.addAll(winnerList);
    }

    public String makeWinnerList() {
        String winnerList = String.join(", ", winners);
        return winnerList;
    }

}
