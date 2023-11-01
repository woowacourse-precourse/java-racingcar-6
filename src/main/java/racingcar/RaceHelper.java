package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.dto.Car;

public class RaceHelper {
    public static List<Car> setCars(List<String> carNames) {
        return carNames
                .stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }
}
