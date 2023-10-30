package racingcar.model;

import java.util.List;

public class Winners {
    private static final String COMMA = ", ";

    private List<String> winners;

    public Winners(List<String> winners) {
        this.winners = winners;
    }


    public String getWinnersName() {
        return String.join(COMMA, winners);
    }
}