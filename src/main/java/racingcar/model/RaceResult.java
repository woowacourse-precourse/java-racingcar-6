package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {

    private static final String DELIMITER = ", ";
    private List<RacingCar> winner;

    public RaceResult() {
        winner = new ArrayList<>();
    }

    public void report(RacingCar racingCar) {
        if (!winner.isEmpty()) {
            if (racingCar.compare(winner.get(0)).isLose()) {
                return;
            }
            if (racingCar.compare(winner.get(0)).isWin()) {
                winner.clear();
            }
        }
        winner.add(racingCar);
    }

    @Override
    public String toString() {
        return this.winner.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(DELIMITER));
    }
}
