package racingcar.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.MovingCondition;

@Component
@RequiredArgsConstructor
public class RacingCarService implements CarService {

    private final MovingCondition racingCarMovingCondition;

    @Override
    public void startRacing(Cars cars) {
        List<Car> racingCars = cars.getRacingCars();

        racingCars.stream()
            .filter(car -> racingCarMovingCondition.canMove())
            .forEach(Car::movePosition);
    }
}
