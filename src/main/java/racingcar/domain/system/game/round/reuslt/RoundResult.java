package racingcar.domain.system.game.round.reuslt;

import racingcar.domain.core.car.BasicCar;
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
        return getPosition((BasicCar) car);
    }

    public Long getPosition(BasicCar car) {
        return cars.getPosition(car);
    }
}
