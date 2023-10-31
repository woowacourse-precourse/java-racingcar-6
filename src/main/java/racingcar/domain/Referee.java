package racingcar.domain;

import java.util.List;
import racingcar.RandomMovementLimitGenerator;
import racingcar.output.PrintService;

public class Referee {

    public static void announceWinner(List<Car> cars) {
        int max = cars.stream().mapToInt(Car::getStraightCount).max()
            .orElseThrow(IllegalArgumentException::new);
        List<String> list = cars.stream().filter(car -> max == car.getStraightCount()).map(Car::getName)
            .toList();
        PrintService.result(list);
    }

    public static void report(List<Car> cars) {
        cars.forEach(car -> {
            int value = RandomMovementLimitGenerator.value();
            car.moveStraight(value);
            PrintService.show(car);
        });
    }

}
