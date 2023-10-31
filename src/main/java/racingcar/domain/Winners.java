package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<String> winners;

    public Winners(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return winners;
    }
}
