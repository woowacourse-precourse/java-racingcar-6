package racingcar.service;

import java.util.List;

import racingcar.domain.Car;
import racingcar.dto.RacingResult;
import racingcar.generator.NumberGenerator;

public class RacingService {
    private static final int MOVE_CONDITION = 4;
    private final NumberGenerator generator;

    public RacingService(NumberGenerator generator) {
        this.generator = generator;
    }

    public List<RacingResult> race(List<Car> cars) {
        return cars.stream()
                .map(this::moveCar)
                .toList();
    }

    private RacingResult moveCar(Car car) {
        if (generator.generateNumber() >= MOVE_CONDITION) {
            car.move();
        }
        return new RacingResult(car.getName(), car.getMovedCount());
    }
}
