package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.MovingCondition;

import java.util.List;

public class RacingCarService {

    private final MovingCondition movingCondition;

    public RacingCarService() {
        this.movingCondition = new MovingCondition();
    }

    public void startRacing(Cars cars) {
        List<Car> racingCars = cars.getRacingCars();

        racingCars.stream()
                .filter(car -> movingCondition.canMove())
                .forEach(Car::movePosition);
    }
}
