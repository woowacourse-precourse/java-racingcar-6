package racingcar;

import java.util.List;
import racingcar.domain.car.Cars;
import racingcar.domain.car.RoundResult;
import racingcar.domain.car.Winners;

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

    public Winners getWinners() {
        return new Winners(cars.getWinners());
    }
}