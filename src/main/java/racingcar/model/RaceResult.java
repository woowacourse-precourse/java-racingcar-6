package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {

    private static final String DELIMITER = ", ";
    private final String winner;

    public RaceResult(List<RacingCar> nominees) {
        winner = nominees.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    @Override
    public String toString() {
        return this.winner;
    }
}
