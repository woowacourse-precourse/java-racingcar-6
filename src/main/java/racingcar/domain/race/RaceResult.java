package racingcar.domain.race;

import racingcar.domain.car.Car;

import java.util.List;

public record RaceResult(
        List<Car> winners
) {
}
