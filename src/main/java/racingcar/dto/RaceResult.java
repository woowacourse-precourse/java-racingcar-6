package racingcar.dto;

import java.util.List;

public class RaceResult {
    private final List<String> winners;

    public RaceResult(List<String> winners) {
        this.winners = winners;
    }
}
