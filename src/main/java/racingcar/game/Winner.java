package racingcar.game;

import java.util.List;
import racingcar.car.Car;

public class Winner {
    public static final String WINNER_DELIMITER = ", ";

    private final List<Car> winners;

    public Winner(List<Car> winners) {
        this.winners = winners;
    }

    public String getWinnerMessage() {
        return String.join(WINNER_DELIMITER, getWinnerNames());
    }

    private List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getCarName)
                .toList();
    }
}
