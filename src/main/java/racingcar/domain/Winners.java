package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class Winners {
    private final List<String> winnersName;

    public Winners(final List<String> winnerName) {
        this.winnersName = winnerName;
    }

    public List<String> getWinnersName() {
        return Collections.unmodifiableList(winnersName);
    }

    @Override
    public String toString() {
        return "최종 우승자 : " + String.join(", ", winnersName);
    }
}
