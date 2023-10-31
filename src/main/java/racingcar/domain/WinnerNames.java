package racingcar.domain;

import java.util.List;

public class WinnerNames {
    private final List<Name> names;

    public WinnerNames(List<Car> winners) {
        this.names = getCarNames(winners);
    }

    private List<Name> getCarNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .toList();
    }

    public String[] getNames() {
        return names.stream()
                .map(Name::toString)
                .toArray(String[]::new);
    }
}
