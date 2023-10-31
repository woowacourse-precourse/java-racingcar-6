package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private List<String> winners;
    public Winners(List<String> winners) {
        this.winners = winners;
    }

    public List<String> getWinners() {
        return Collections.unmodifiableList(winners);
    }

}
