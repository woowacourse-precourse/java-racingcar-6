package racingcar.service;

import racingcar.domain.MoveCondition;
import racingcar.domain.car.Car;
import racingcar.domain.CarGarage;

import java.util.List;

public class RacingService {

    public void race(CarGarage garage) {
        List<Car> cars = garage.cars();
        for (Car car : cars) {
            MoveCondition condition = MoveCondition.getCondition();
            car.updatePositionBy(condition);
        }
    }

}
