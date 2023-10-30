package racingcar.domain.system.game.round.reuslt;

import racingcar.domain.core.car.OnRaceCar;
import racingcar.domain.core.car.OnRaceCars;

public class RoundResult {

    private final OnRaceCars cars;

    public RoundResult(OnRaceCars cars) {
        this.cars = cars;
    }


    public OnRaceCars getAllCars() {
        return cars;
    }

    public Long getPosition(OnRaceCar car) {
        return cars.getPosition(car);
    }
}
