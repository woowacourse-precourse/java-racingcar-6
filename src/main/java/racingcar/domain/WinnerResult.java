package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerResult {
    private static final String DELIMITER = ", ";
    private final List<Car> winners;

    private WinnerResult(final List<Car> winners) {
        this.winners = winners;
    }

    public static WinnerResult create(final List<Car> winners) {
        return new WinnerResult(winners);
    }

    public String getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }
}
