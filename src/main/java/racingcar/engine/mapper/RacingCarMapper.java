package racingcar.engine.mapper;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.engine.domain.Car;

public class RacingCarMapper {
    public RacingCarMapper() {
    }

    public Integer toInteger(String s) {
        return Integer.parseInt(s);
    }

    public List<Car> toCars(List<String> carNames) {
        return carNames.stream().map(Car::new).toList();
    }

    public String toProgressBar(List<Car> cars) {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    public String toNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
