package racingcar.domain;

import java.util.List;

public class Winners {

    private final List<String> winners;

    public Winners(List<String> winnerList) {
        winners = winnerList;
    }

    public String makeWinnerList() {
        return String.join(", ", winners);
    }

}
