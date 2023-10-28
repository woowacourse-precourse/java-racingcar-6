package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.MovingCondition;

import java.util.List;
import java.util.stream.IntStream;

public class RacingCarService {

    private static final int FIRST_ATTEMPT = 0;

    private final MovingCondition movingCondition;

    public RacingCarService() {
        this.movingCondition = new MovingCondition();
    }

    public void startRacing(Cars cars, int attemptCount) {
        List<Car> racingCars = cars.getRacingCars();

        IntStream.range(FIRST_ATTEMPT, attemptCount)
                .forEach(attempt -> racingCars.stream()
                        .filter(i -> movingCondition.canMove())
                        .forEach(Car::movePosition));
    }

}
