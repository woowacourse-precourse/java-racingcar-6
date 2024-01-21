package racingcar.service;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.MovingCondition;

public class RacingCarService implements CarService {

    private final MovingCondition movingCondition;

    public RacingCarService(MovingCondition movingCondition) {
        this.movingCondition = movingCondition;
    }

    @Override
    public void startRacing(Cars cars) {
        List<Car> racingCars = cars.getRacingCars();

        racingCars.stream()
            .filter(car -> movingCondition.canMove())
            .forEach(Car::movePosition);
    }
}
