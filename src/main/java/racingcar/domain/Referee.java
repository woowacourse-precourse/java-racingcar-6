package racingcar.domain;

import java.util.List;
import racingcar.RandomMovementLimitGenerator;

public class Referee {

    public static List<String> determineWinner(List<Car> cars) {
        int max = cars.stream().mapToInt(Car::getStraightCount).max()
            .orElseThrow(IllegalArgumentException::new);
        return cars.stream().filter(car -> max == car.getStraightCount()).map(Car::getName)
            .toList();
    }

    public static List<Car> report(List<Car> cars) {
        cars.forEach(car -> {
            int value = RandomMovementLimitGenerator.value();
            car.moveStraight(value);
        });
        return cars;
    }

}
