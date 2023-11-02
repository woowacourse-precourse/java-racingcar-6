package racingcar.domain;

import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }


    public List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .toList();
    }
}
