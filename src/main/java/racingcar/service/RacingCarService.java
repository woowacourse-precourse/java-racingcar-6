package racingcar.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.MovingCondition;

@Component
public class RacingCarService implements CarService {

    private final MovingCondition movingCondition;

    @Autowired
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
