package racingcar.application;

import racingcar.domain.Car;
import racingcar.dto.RacingResult;
import racingcar.generator.NumberGenerator;

import java.util.List;

import static racingcar.enums.RacingConfig.MOVE_CONDITION;

public class RacingService {
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
        if (generator.generateNumber() >= MOVE_CONDITION.getValue()) {
            car.move();
        }
        return RacingResult.from(car);
    }

    public List<String> selectWinners(List<Car> cars) {
        int maxMovedCount = getMaxMovedCount(cars);

        return cars.stream()
                .filter(car -> car.isSameMovedCount(maxMovedCount))
                .map(Car::getName)
                .toList();
    }

    private int getMaxMovedCount(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMovedCount)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차가 존재하지 않습니다."));
    }
}
