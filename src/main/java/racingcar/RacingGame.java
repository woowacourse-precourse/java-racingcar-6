package racingcar;

import java.util.List;
import racingcar.domain.car.Cars;

public class RacingGame {
    private final Cars cars;

    public RacingGame(List<String> carNames) {
        this.cars = new Cars(carNames);
    }
}