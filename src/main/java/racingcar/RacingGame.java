package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;

public class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }
}
