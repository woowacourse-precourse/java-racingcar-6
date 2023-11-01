package racingcar.engine.mapper;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.engine.domain.Car;

public class RacingCarMapper {
    public RacingCarMapper() {
    }

    public List<Car> toCars(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    public String toNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
