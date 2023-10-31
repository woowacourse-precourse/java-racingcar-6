package racingcar.application;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.RacingResult;
import racingcar.generator.NumberGenerator;

import java.util.List;

import static racingcar.enums.RacingConfig.MOVE_CONDITION;

public class RacingService {
    private final NumberGenerator generator;

    public RacingService(NumberGenerator generator) {
        this.generator = generator;
    }

    public List<RacingResult> race(Cars cars) {
        return cars.getCars().stream()
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
        int maxMovedCount = getMaxMovedCount(cars);

        return cars.getCars().stream()
                .filter(car -> car.isSameMovedCount(maxMovedCount))
                .map(Car::getName)
                .toList();
    }

    private int getMaxMovedCount(Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getMovedCount)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차가 존재하지 않습니다."));
    }
}
