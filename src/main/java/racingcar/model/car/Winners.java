package racingcar.model.car;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<String> winnerNames;

    public Winners(List<Car> winners) {
        winnerNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}
