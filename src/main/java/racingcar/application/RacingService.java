package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.RacingResult;
import racingcar.generator.NumberGenerator;

import java.util.List;
import java.util.stream.IntStream;

import static racingcar.enums.RacingConfig.MOVE_CONDITION;

public class RacingService {
    private final NumberGenerator generator;

    public RacingService(NumberGenerator generator) {
        this.generator = generator;
    }

    public List<RacingResult> race(Cars cars) {
        return IntStream.range(0, cars.size())
                .mapToObj(cars::findCar)
                .map(this::moveCar)
                .toList();
    }

    private RacingResult moveCar(Car car) {
        if (generator.generateNumber() >= MOVE_CONDITION.getValue()) {
            car.move();
        }
        return RacingResult.from(car);
    }

    public List<String> selectWinners(Cars cars) {
        int maxMovedCount = cars.getMaxMovedCount();
        return IntStream.range(0, cars.size())
                .mapToObj(cars::findCar)
                .filter(car -> car.isSameMovedCount(maxMovedCount))
                .map(Car::getName)
                .toList();
    }
}
