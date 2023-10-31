package racingcar.domain;

import java.util.List;
import racingcar.strategy.RacingCarMoveStrategy;

public record Participants(List<Car> cars) {

    public static Participants of(List<String> names) {
        return new Participants(names.stream().map(Car::new).toList());
    }

    public Participants moveAll(RacingCarMoveStrategy racingCarMoveStrategy) {
        return new Participants(cars.stream()
                .map(car -> car.move(racingCarMoveStrategy))
                .toList()
        );
    }
}
