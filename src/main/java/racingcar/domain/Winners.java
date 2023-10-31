package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Winners {
    private final CarNames winnersName;

    public Winners(final CarNames winnerName) {
        this.winnersName = winnerName;
    }

    public CarNames getWinnersName() {
        return winnersName;
    }

    @Override
    public String toString() {
        return "최종 우승자 : " + String.join(", ", winnersName.toString());
    }
}
