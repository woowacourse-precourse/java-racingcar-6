package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private List<String> winners = new ArrayList<>();

    public Winners(List<String> winnerList) {
        winners.addAll(winnerList);
    }

    public String makeWinnerList() {
        return String.join(", ", winners);
    }

}
