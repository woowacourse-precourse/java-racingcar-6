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

    public static String getWinners(List<Car> cars) {
        Integer maxMoveCount = cars
                .stream()
                .map(car -> car.getState().length())
                .reduce(0, Integer::max);

        List<String> winners = cars
                .stream()
                .filter(car -> car.getState().length() == maxMoveCount)
                .map(car -> car.getName())
                .collect(Collectors.toList());

        return String.join(", ", winners);

    }
}
