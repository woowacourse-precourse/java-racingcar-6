package racingcar;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.car.RoundResult;

public class RacingGame {
    private final Cars cars;

    public RacingGame(List<String> carNames) {
        this.cars = new Cars(carNames);
    }

    public void race() {
        cars.race();
    }

    public RoundResult getRoundResult() {
        return new RoundResult(cars.getCarDTOs());
    }
}