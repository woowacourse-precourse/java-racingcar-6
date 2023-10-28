package racingcar.domain;

import java.util.List;

public class WinnerResult {
    private final List<Car> winners;

    private WinnerResult(final List<Car> winners) {
        this.winners = winners;
    }

    public static WinnerResult create(final List<Car> winners) {
        return new WinnerResult(winners);
    }

    public List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .toList();
    }
}
